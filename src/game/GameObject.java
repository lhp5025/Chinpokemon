
package game;

import gui.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyVetoException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import world.World;

/**
 * @author LHP5025
 * 
 * 
 */
public class GameObject extends JFrame implements Runnable {

    private long delta_time; // Time between each compute frame
    private final JLayeredPane game_panels; // Layerd panel for holding all of the different compenents of the game
    private final GamePanel game_render_panel; // The panel for rendering the display of the world and the player
    private final Inventory_Panel game_inventory_panel; // The panel for managing and viewing the players inventory
    private final BattleFrame battle_pannel; // The frame where battles take place
    private final JLabel _rnder_time_text = new JLabel(); // The text that displays the games render stats.
    private Vector player_movement_input_vector = new Vector(0.0, 0.0); // The player movement vector (i.e. their direction (not velocity))
    private int target_delta_time = 15; // The target framreate for the gmae
    private double theta_time = 1; // The percentage of the target delat time achived
    private boolean IS_RUNNING = true; // Boolean to manage the running of the game loop
    
    public final BattleObject battleSystem = new BattleObject(this); // The games battle system object, for coordinating, and managing battles
    public final World world = new World(this); // The games world object
    public final PlayerObject player_1 = new PlayerObject(); // THe games players, players objects
    
    private Thread game_thread; // The game loop thead

    public long getDelta_time() {
        return delta_time;
    }
    
    public double getTheta_time() {
        return theta_time;
    }
    
    public PlayerObject getPlayer() {
        return player_1;
    }
    
    // Signal for the game to start a battle
    public void battleSysStart(ChinpokemonObject _enemy) {
        // Open battle window
        
        // Find the approprita chinpokemon for the player
        /// If no active chinpokemon, choose random one from their inventory for them
        /// THen init new battle
        if (player_1.activeChinpokemon == null) {
            if (player_1.inventory.getChinpokemon().size() == 0) {
                // Error, no player chinokemon to battle
            } else {
                player_1.activeChinpokemon = player_1.inventory.getChinpokemon().get(new Random().nextInt( player_1.inventory.getChinpokemon().size() ) );
                battleSystem.newBattle(_enemy, player_1.activeChinpokemon);
            }
        } 
        else {
            battleSystem.newBattle(_enemy, player_1.activeChinpokemon);
        }
        
        battle_pannel.requestFocus(); // Set focus to the battle frame
        battle_pannel.ReInit(this); // Reint battle frame for new battle
        battle_pannel.setVisible(true); // Make the battle frame visiable
        
        // Remove listeners + stop player (bug fix)
        this.removeKeyListener(this.getKeyListeners()[0]);
        player_movement_input_vector = new Vector(0.0, 0.0); // Stop the player from moving
        
        // Start battle
        this.battleSystem.newBattle(_enemy, player_1.activeChinpokemon);
    }
    
    // Signal for the change in the battle state
    public void battleStateChange(String _msg) {
        battle_pannel.upDate(_msg); // update the display of the battle panel
    }
    
    // Signal for the ending of the battle
    public void battleSysEnd() {
        // Close battle window
        battle_pannel.setVisible(false);
        
        // Re-add Key listeners
        this.addKeyListener( new KeyBindings() );
        
        // Set focus to the Jframe
        this.requestFocus();
    }
    
    public GameObject() {
        // Init for display games frame
        this.setVisible(true);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Closing the window exits the program
        this.addKeyListener( new KeyBindings() ); // Add key listeners
        this.addMouseWheelListener( new MouseBindings() ); // Add mouse listeners
        
        // Init, layer pane
        game_panels = new JLayeredPane();
        game_panels.setDoubleBuffered(true);
        
        // Init, and add render pannel to layer pane on layer 1
        game_render_panel = new GamePanel(this);
        game_panels.add(game_render_panel, new Integer(1));
        
        // Init, and add inventory panel to layered pane on layer 2
        game_inventory_panel = new Inventory_Panel(this);
        game_inventory_panel.setVisible(false);
        game_panels.add(game_inventory_panel, new Integer(2));
        
        // Init, and add battle frame to layered pane on layer 4
        battle_pannel = new BattleFrame();
        battle_pannel.setVisible(false);
        game_panels.add(battle_pannel, new Integer(4));
        try {
            battle_pannel.setMaximum(true); // Have the battle frame take up the entier game frame
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Init, and add button for opening inventory on layer 3
        JButton openInventory = new JButton();
        openInventory.setText("Inventory");
        openInventory.setSize(150, 50);
        openInventory.setFocusable(false);
        openInventory.setVisible(true);
        openInventory.addActionListener(new AbstractAction("name of button") {
            @Override
            public void actionPerformed(ActionEvent e) {
                game_inventory_panel.repaint();
                game_inventory_panel.reInit();
                game_inventory_panel.setVisible( !game_inventory_panel.isVisible() );
            }
        });
        game_panels.add(openInventory , new Integer(3));
        
        // Init, and add render stats text on layer 4
        _rnder_time_text.setBounds(0, 0, 800, 30);
        _rnder_time_text.setForeground(Color.black);
        _rnder_time_text.setVisible(false);
        game_panels.add(_rnder_time_text, new Integer(10));
        
        // Add layer pane to the game frame
        this.add(game_panels);
        
        // Shhhhh
        game_thread = new Thread(this, "GameThread");
        game_thread.setPriority(Thread.MAX_PRIORITY);
        game_thread.start(); // Start game loop
    }

    // Thread for the game loop
    @Override
    public synchronized void run() {
        // Game Loop
        long start_time;// Loop timer
        
        // While the game is running 
        while (IS_RUNNING) {
            start_time = System.currentTimeMillis(); // Start frame calc.
            
            //! Loop functionality
            
            // Set render time info
            _rnder_time_text.setText("FPS:" + String.format("%1.0f", 1000.0 / (1.0* this.getDelta_time() ))+" (" +this.delta_time +")" + " Render_T(ms):" + String.valueOf(game_render_panel.render_time) );
            
            world.movePlayer( player_movement_input_vector ); // Move player based on movement vector
            
            this.repaint(); // Repaint everyting in the game Jframe
           
            //! End loop functionality
            
            // If the loop taks shorter than target_framerate (default 63Hz), sleep till time is up
            long current_time_for_loop = System.currentTimeMillis() - start_time;
            if (current_time_for_loop  < target_delta_time) {
                try {
                    this.wait(target_delta_time - current_time_for_loop);
                    //this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.toString());
                }
            }
            delta_time = System.currentTimeMillis() - start_time; // Time it took to compute loop
            theta_time = target_delta_time /  delta_time ; // Percent of target time achived
        }

    }
    
    @Override
    public void dispose(){
        // If the jframe is closed, stop the thread
        IS_RUNNING = false;
        super.dispose();
    }
    
    // A mapping for mouse wheel bindings for the game object
    public class MouseBindings implements MouseWheelListener {
        
        // Zoom in or out using the mouse wheel
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            //System.out.println(e.getWheelRotation() );
            game_render_panel.zoom(e.getWheelRotation());
        }

    }
    
    // A mapping for key bindings for the game object
    public class KeyBindings implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            // alt+z -> Enable/Dissable Runtime info
            if ((ke.getKeyChar() == 'z' || ke.getKeyChar() == 'Z') && ke.getModifiers() == 8){
                _rnder_time_text.setVisible( !_rnder_time_text.isVisible() );
            }
            // Open close inventory
            if (ke.getKeyChar() == 'i' || ke.getKeyChar() == 'I'){
                game_inventory_panel.repaint();
                game_inventory_panel.reInit();
                game_inventory_panel.setVisible( !game_inventory_panel.isVisible() );
            }
            
        }
        
        // Amend the players movement vecor depending on what keys are down
        @Override
        public void keyPressed(KeyEvent ke) {
            // Up
            if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W'){
                player_movement_input_vector.setY(-1);
            }
            // Left
            if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A'){
                player_movement_input_vector.setX(-1);
            }
            // Down
            if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S'){
                player_movement_input_vector.setY(1);
            }
            // Right
            if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D'){
               player_movement_input_vector.setX(1);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            // Up
            if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W'){
                player_movement_input_vector.setY(0);
            }
            // Left
            if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A'){
                player_movement_input_vector.setX(0);
            }
            // Down
            if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S'){
                player_movement_input_vector.setY(0);
            }
            // Right
            if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D'){
               player_movement_input_vector.setX(0);
            } 
        }
        
    }
    
}
