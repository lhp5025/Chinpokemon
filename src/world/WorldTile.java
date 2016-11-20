/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public abstract class WorldTile implements Serializable {
    
    // Tile image mapping
    public static final HashMap<String, ImageIcon> TILE_IMGICON_MAP = new  HashMap();
    static {
        TILE_IMGICON_MAP.put("", new ImageIcon(Class.class.getResource("/rsc/dark.png")) );
        TILE_IMGICON_MAP.put("grass_1", new ImageIcon(Class.class.getResource("/rsc/grass_1.png")) );
        TILE_IMGICON_MAP.put("grass_2", new ImageIcon(Class.class.getResource("/rsc/grass_2.png")) );
        TILE_IMGICON_MAP.put("grass_3", new ImageIcon(Class.class.getResource("/rsc/grass_3.png")) );
        TILE_IMGICON_MAP.put("sidewalk_1", new ImageIcon(Class.class.getResource("/rsc/sidewalk_1.png")) );
        TILE_IMGICON_MAP.put("dirt_1", new ImageIcon(Class.class.getResource("/rsc/dirt_1.png")) );
        TILE_IMGICON_MAP.put("dirt_puddle_1", new ImageIcon(Class.class.getResource("/rsc/dirt_puddle_1.png")) );
        TILE_IMGICON_MAP.put("water_a1", new ImageIcon(Class.class.getResource("/rsc/water_a1.gif")) );
        TILE_IMGICON_MAP.put("wall_basic_1", new ImageIcon(Class.class.getResource("/rsc/wall_basic_1.png")) );
        TILE_IMGICON_MAP.put("shrub_basic", new ImageIcon(Class.class.getResource("/rsc/shrub_basic.png")) );
    }
    
    protected ImageIcon bg_image = null;
    protected ImageIcon fg_image = null;
    protected String BG_IMGICON_MAP = "";
    protected String FG_IMGICON_MAP = "";
    protected String name = "";
    public final String type;

    public Image getBg_image() {
        return TILE_IMGICON_MAP.get(BG_IMGICON_MAP).getImage();
    }

    public Image getFg_image() {
         return TILE_IMGICON_MAP.get(FG_IMGICON_MAP).getImage();
    }

    public String getName() {
        return name;
    }

    public WorldTile(String _bg_image, String _fg_image, String _name, String _type) {
        BG_IMGICON_MAP = _bg_image;
        FG_IMGICON_MAP = _fg_image;
        name = _name;
        type = _type;
    }

    public WorldTile(String _bg_image, String _fg_image, String _type) {
        BG_IMGICON_MAP = _bg_image;
        FG_IMGICON_MAP = _fg_image;
        type = _type;
    }

    public WorldTile(String _bg_image, String _type) {
        BG_IMGICON_MAP = _bg_image;
        type = _type;
    }

    @Override
    public String toString() {
        return type + ":" + name;
    }


}
