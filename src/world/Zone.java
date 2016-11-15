/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public class Zone implements Serializable {
    private WorldTile[][] zone_tiles; // X, Y
    
    public final String name;
    public final static WorldTile grass_1 = new FloorTile( new ImageIcon(Class.class.getResource("/rsc/grass_1.png")));
    public final static WorldTile wall_basic_1 = new FloorTile( new ImageIcon(Class.class.getResource("/rsc/wall_basic_1.png")));
    
    public WorldTile[][] getZone_tiles() {
        return zone_tiles;
    }
    
    public Zone(String _name,  WorldTile[][] _zone_tiles) {
        name = _name;
        zone_tiles = _zone_tiles;
    }
}
