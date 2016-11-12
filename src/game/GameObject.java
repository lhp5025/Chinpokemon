/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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

    private long delta_time;// Time between each compute frame
    private final JLayeredPane game_panels;
    private final GamePanel game_render_panel;
    private final InventoryPanel game_inventory_panel;
    private final JLabel _rnder_time_text = new JLabel();
    private Vector player_movement_input_vector = new Vector(0.0, 0.0);
    private PlayerObject player_1 = new PlayerObject();
    private int target_delta_time = 10;
    
    public final World world = new World(this);
    public Thread game_thread;

    public long getDelta_time() {
        return delta_time;
    }
    
    public PlayerObject getPlayer() {
        return player_1;
    }

    public GameObject() {
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener( new KeyBindings() );
        this.addMouseWheelListener( new MouseBindings() );
        
        game_panels = new JLayeredPane();
        game_panels.setDoubleBuffered(true);
        
        game_render_panel = new GamePanel(this);
        game_panels.add(game_render_panel, new Integer(1));
        
        
        game_inventory_panel = new InventoryPanel(this);
        game_panels.add(game_inventory_panel, new Integer(2));
        
        _rnder_time_text.setBounds(0, 0, 800, 30);
        _rnder_time_text.setBackground(Color.black);
        _rnder_time_text.setForeground(Color.white);
        
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
        while (true) {
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
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.toString());
                }
            }
            delta_time = System.currentTimeMillis() - start_time;// Time it took to compute loop
        }

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
