/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Luke
 */
public class ImagePanel extends JPanel{
    private Image image;
    
    public ImagePanel(Image _img) {
        super();
        image = image;
    }
    
    public ImagePanel() {
        super();
        image = null;
    }
    
    public void setImage(Image _img) {
        image = _img;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
