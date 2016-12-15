
package world;

import javax.swing.ImageIcon;

/**
 * @author LHP5025
 * 
 * Class for all floor tiles in the world
 */
public class FloorTile extends WorldTile {
    
    public FloorTile(String _bg_image, String _fg_image, String _name) {
        super(_bg_image, _fg_image, _name, "FLOOR");
    }
    
    public FloorTile(String _bg_image, String _name) {
        super(_bg_image, "FLOOR");
        this.name = _name;
    }
    
    public FloorTile(String _bg_image) {
        super(_bg_image, "FLOOR");
    }
}
