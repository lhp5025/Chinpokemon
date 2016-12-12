/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import game.ChinpokemonObject;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public class Zone implements Serializable {
    private final WorldTile[][] zone_tiles; // X, Y
    public final String name;
    public final int width;
    public final int heihgt;
 
    // Floor Tiles
    public final static WorldTile grass_1 = new FloorTile( "grass_1", "grass" );
    public final static WorldTile grass_2 = new FloorTile( "grass_2","grass"  );
    public final static WorldTile grass_3 = new FloorTile(  "grass_3","grass"  );
    public final static WorldTile sidewalk = new FloorTile(  "sidewalk_1", "sidewalk" );
    public final static WorldTile dirt = new FloorTile( "dirt_1", "dirt" );
    public final static WorldTile dirt_puddle = new FloorTile( "dirt_puddle_1", "dirt" );
    // Wall tiles
    public final static WorldTile water = new WallTile( "water_a1","water" );
    public final static WorldTile wall_basic = new WallTile( "wall_basic_1", "wall" );
    public final static WorldTile shrub_basic = new WallTile( "shrub_basic", "shrub" );
    
    public WorldTile[][] getZone_tiles() {
        return zone_tiles;
    }
    
    public Zone(String _name,  WorldTile[][] _zone_tiles) {
        name = _name;
        zone_tiles = _zone_tiles;
        width = _zone_tiles.length;
        heihgt = _zone_tiles[0].length;
    }
}
