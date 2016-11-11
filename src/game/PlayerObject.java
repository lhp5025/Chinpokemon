/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;

/**
 *
 * @author CXM818
 */
public class PlayerObject {
    
    protected ImageIcon player_image = new ImageIcon(Class.class.getResource("/rsc/player_1.png"));
    public String type;
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImageIcon getPlayer_image() {
        return player_image;
    }

    public void setPlayer_image(ImageIcon player_image) {
        this.player_image = player_image;
    }

    
}
