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
    private Image image;
    public Boolean aspectLock = false;
    
    
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
    
    public void setAspectLock( Boolean _set) {
        aspectLock = _set;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        if (aspectLock) { 
            int maxDimension = Math.min(this.getWidth(), this.getHeight());
            this.setSize(maxDimension, maxDimension);
            this.setPreferredSize(new Dimension(maxDimension, maxDimension));
        }
        
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
