/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import world.WorldTile;

/**
 *
 * @author Cory
 */
public class WorldBuilderPanel extends JPanel{
    
    private Image background_image;
    private WorldTile[][] worldArray;
    private int BLOCK_SIZE = 32;
    
    public WorldBuilderPanel( WorldTile[][] worldArray) {
        this.setBounds(0,0,worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE);
        this.setVisible(true);
//        background_image = new ImageIcon(Class.class.getResource("/rsc/water_1.png")).getImage();
        this.addMouseListener(new MouseClicky(this));
        this.setAutoscrolls(true);
        this.setBackground(Color.red);
        this.worldArray = worldArray;
    }
    
    @Override
    public void paint(Graphics g) {
        ///g.drawImage(background_image, 0, 0, 32, 32, this);
        
        for(int x = 0; x < worldArray.length; x++ ){
            for(int y = 0; y < worldArray[x].length; y++ ){
                g.drawImage(worldArray[x][y].getBg_image(), x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, this);
            }
        }
        
    }
    
    public class MouseClicky implements MouseListener {
        public final JPanel parent;
        
        public MouseClicky(JPanel _parent){
            parent = _parent;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
            int x = e.getX();
            System.out.println(x);
            int y = e.getY();
            System.out.println(y);
            x = (int) Math.floor(x / 32);
            System.out.println(x);
            y = (int) Math.floor(y / 32);
            System.out.println(y);
            parent.repaint();
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
