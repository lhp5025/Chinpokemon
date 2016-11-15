/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public class WallTile extends WorldTile {
    
    public WallTile(ImageIcon _bg_image, ImageIcon _fg_image, String _name) {
        super(_bg_image, _fg_image, _name, "WALL");
    }
    public WallTile(ImageIcon _bg_image, ImageIcon _fg_image) {
        super(_bg_image, _fg_image,"WALL");
    }
    public WallTile(ImageIcon _bg_image, String _name) {
        super(_bg_image, "WALL");
        this.name = _name;
    }
    public WallTile(ImageIcon _bg_image) {
        super(_bg_image, "WALL");
    }
}
