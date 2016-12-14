/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Luke
 */
public class ImagePanel extends JPanel{
    private Image image = null;
    public Boolean aspectLock = false;
    
    
    public ImagePanel(Image _img) {
        super();
        image = _img;
    }
    
    public ImagePanel() {
        super();
    }
    
    public void setImage(Image _img) {
        image = _img;
        repaint();
    }
    
    public void setAspectLock( Boolean _set) {
        aspectLock = _set;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        
    }
}
