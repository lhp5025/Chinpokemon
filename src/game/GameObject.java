/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import world.World;

/**
 * @author LHP5025
 */
public class GameObject extends JFrame implements Runnable {

    private long delta_time; // Time between each compute frame
    private final JLayeredPane game_panels;
    private final GamePanel game_render_panel;
    private final Inventory_Panel game_inventory_panel;
    private final BattleFrame battle_pannel;
    private final JLabel _rnder_time_text = new JLabel();
    private Vector player_movement_input_vector = new Vector(0.0, 0.0);
    private int target_delta_time = 15;
    private double theta_time = 1;
    private boolean IS_RUNNING = true;
    
    public final BattleObject battleSystem = new BattleObject(this);
    public final World world = new World(this);
    public final PlayerObject player_1 = new PlayerObject();
    public Thread game_thread;

    public long getDelta_time() {
        return delta_time;
    }
    
    public double getTheta_time() {
        return theta_time;
    }
    
    public PlayerObject getPlayer() {
        return player_1;
    }
    
    public void battleSysStart(ChinpokemonObject _enemy) {
        // Open battle window
        
        // Propt user to choose their battle chinpokemon
        
        // Start battle
        this.battleSystem.newBattle(_enemy, player_1.activeChinpokemon);
    }
    
    public GameObject() {
        // Init for display window
        this.setVisible(true);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Closing the window exits the program
        this.addKeyListener( new KeyBindings() ); // Add key listeners
        this.addMouseWheelListener( new MouseBindings() ); // Add mouse listeners
        
        
        
        game_panels = new JLayeredPane();
        game_panels.setDoubleBuffered(true);
        
        game_render_panel = new GamePanel(this);
        game_panels.add(game_render_panel, new Integer(1));
        
        
        game_inventory_panel = new Inventory_Panel(this);
        game_inventory_panel.setVisible(false);
        game_panels.add(game_inventory_panel, new Integer(2));
        
        battle_pannel = new BattleFrame();
        battle_pannel.setVisible(false);
        game_panels.add(battle_pannel, new Integer(3));
        try {
            battle_pannel.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        _rnder_time_text.setBounds(0, 0, 800, 30);
        _rnder_time_text.setBackground(Color.black);
        _rnder_time_text.setForeground(Color.white);
        _rnder_time_text.setVisible(false);
        
        game_panels.add(_rnder_time_text, new Integer(10));
        
        this.add(game_panels);
        //!!
        // Shhhhh
        game_thread = new Thread(this, "GameThread");
        game_thread.setPriority(Thread.MAX_PRIORITY);
        game_thread.start();
    }

    @Override
    public synchronized void run() {
        // Game Loop
        long start_time;// Loop timer
        while (IS_RUNNING) {
            start_time = System.currentTimeMillis();
            //// Loop functionality
            _rnder_time_text.setText("FPS:" + String.format("%1.0f", 1000.0 / (1.0* this.getDelta_time() ))+" (" +this.delta_time +")" + " Render_T(ms):" + String.valueOf(game_render_panel.render_time) );
            
            world.movePlayer( player_movement_input_vector );
            
            this.repaint();
           
            //// End loop functionality
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
            delta_time = System.currentTimeMillis() - start_time;// Time it took to compute loop
            theta_time = target_delta_time /  delta_time ;
        }

    }
    
    @Override
    public void dispose(){
        IS_RUNNING = false;
        super.dispose();
    }
    
    public class MouseBindings implements MouseWheelListener {

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            //System.out.println(e.getWheelRotation() );
            game_render_panel.zoom(e.getWheelRotation());
        }

    }
    
    public class KeyBindings implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            //System.out.println("KEY TYPED: " + ke );
            
            // alt+z -> Enable/Dissable Runtime info
            if ((ke.getKeyChar() == 'z' || ke.getKeyChar() == 'Z') && ke.getModifiers() == 8){
                _rnder_time_text.setVisible( !_rnder_time_text.isVisible() );
            }
            // Open close inventory
            if (ke.getKeyChar() == 'i' || ke.getKeyChar() == 'I'){
                game_inventory_panel.repaint();
                game_inventory_panel.setVisible( !game_inventory_panel.isVisible() );
            }
            
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            //System.out.println(ke + "KEY PRESSED: ");
            if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W'){
                player_movement_input_vector.setY(-1);
            }
            
            if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A'){
                player_movement_input_vector.setX(-1);
            }
            
            if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S'){
                player_movement_input_vector.setY(1);
            }
            
            if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D'){
               player_movement_input_vector.setX(1);
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W'){
                player_movement_input_vector.setY(0);
            }
            
            if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A'){
                player_movement_input_vector.setX(0);
            }
            
            if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S'){
                player_movement_input_vector.setY(0);
            }
            
            if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D'){
               player_movement_input_vector.setX(0);
            } 
        }
        
    }
    
}
