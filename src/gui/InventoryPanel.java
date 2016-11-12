/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.GameObject;
import java.awt.Graphics;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Luke
 */
public class InventoryPanel extends JPanel {
    private final GameObject game_data;
    
    public InventoryPanel(GameObject _data_source) {
        game_data = _data_source;
        this.setVisible(true);
        this.setBounds(50, 50, 630, 480);
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBounds(50, 50, 630, 480);
    }
    
}
