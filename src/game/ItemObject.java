
package game;

import java.awt.Image;

/**
 * @author CXM818
 * 
 *  Item Object
 */
public abstract class ItemObject{
    
    public final String name; // Name of the item
    public final String description; // Descpription of the item
    public final Image image; // Image for the item
    
    // Abstract method for using the item
    public abstract void use(ChinpokemonObject _obj);
    
    public ItemObject (String _name, String _desc, Image _img) {
        this.name = _name;
        this.description = _desc;
        this.image = _img;
    }
    
    public ItemObject (String _name, String _desc) {
        this.name = _name;
        this.description = _desc;
        this.image = null;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
