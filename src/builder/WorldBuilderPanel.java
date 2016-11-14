/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Cory
 */
public class WorldBuilderPanel extends JPanel{
    
    private Image background_image;
    
    public WorldBuilderPanel() {
        this.setSize(200, 200);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(background_image, 0, 0, 100, 100, this);
    }
}
