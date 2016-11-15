/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public abstract class WorldTile {
    protected ImageIcon bg_image = null;
    protected ImageIcon fg_image = null;
    protected String name = "";
    public final String type;
    
    public Image getBg_image() {
        return bg_image.getImage();
    }

    public Image getFg_image() {
        return fg_image.getImage();
    }

    public String getName() {
        return name;
    }
    
    public WorldTile(ImageIcon _bg_image, ImageIcon _fg_image, String _name, String _type){
        bg_image = _bg_image;
        fg_image = _fg_image;
        name = _name;
        type = _type;
    }
    public WorldTile(ImageIcon _bg_image, ImageIcon _fg_image, String _type){
        bg_image = _bg_image;
        fg_image = _fg_image;
        type = _type;
    }
    public WorldTile(ImageIcon _bg_image, String _type){
        bg_image = _bg_image;
        type = _type;
    }
    
    @Override
    public String toString() {
        return type + ":" + name;
    }
}
