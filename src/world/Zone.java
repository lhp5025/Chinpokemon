/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.ArrayList;

/**
 *
 * @author LHP5025
 */
public class Zone {
    private WorldTile[][] zone_tiles; // X, Y
    
    public final String name;
    
    public WorldTile[][] getZone_tiles() {
        return zone_tiles;
    }
    
    public Zone(String _name,  WorldTile[][] _zone_tiles) {
        name = _name;
        zone_tiles = _zone_tiles;
    }
}
