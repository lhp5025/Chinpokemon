/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gui.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
    private final JLabel _rnder_time_text = new JLabel();
    private Point2D player_movement_input_vector = new Point2D.Double(0.0, 0.0);
    
    
    public final World world = new World(this);
    public Thread game_thread;

    public long getDelta_time() {
        return delta_time;
    }

    public GameObject() {
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener( new KeyBindings() );
        
        game_panels = new JLayeredPane();
        game_panels.setDoubleBuffered(true);
        
        game_render_panel = new GamePanel(this);
        game_panels.add(game_render_panel, new Integer(1));
        this.add(game_panels);
        //!! Tempt delta time text
        _rnder_time_text.setBounds(0, 0, 800, 30);
        game_panels.add(_rnder_time_text, new Integer(10));
        //!!
        
        // Shhhhh
        game_thread = new Thread(this);
        game_thread.start();
    }

    @Override
    public synchronized void run() {
        // Game Loop
        long start_time;// Loop timer
        while (true) {
            start_time = System.currentTimeMillis();
            //// Loop functionality
            _rnder_time_text.setText("DeltaTime(ms): " + String.valueOf(this.getDelta_time()) + "RenderTime(ms): " + String.valueOf(game_render_panel.render_time) + " PlayerLocation:" + world.getPlayer_location() );
            
            world.movePlayer( player_movement_input_vector );
            
            this.repaint();

            //// End loop functionality
            // If the loop taks shorter than 15.5ms (15500 ns) (60Hz), sleep till time is up
            if (System.currentTimeMillis() - start_time < 15) {
                try {
                    this.wait((15 - (System.currentTimeMillis() - start_time)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            delta_time = System.currentTimeMillis() - start_time;// Time it took to compute loop
        }

    }
    
    public class KeyBindings implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            //System.out.println(ke + "KEY TYPED: ");
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            //System.out.println(ke + "KEY PRESSED: ");
            switch ( ke.getKeyChar() ) {
                case 'w':
                    player_movement_input_vector.setLocation(0, -1.0);
                    break;
                case 'a':
                    player_movement_input_vector.setLocation(-1.0, 0);
                    break;
                case 's':
                    player_movement_input_vector.setLocation(0,  1.0);
                    break;
                case 'd':
                    player_movement_input_vector.setLocation(1.0 , 0);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            player_movement_input_vector.setLocation(0, 0);
        }
        
    }
    
}
