
package game;

import game.chinpokemon.*;
import javax.swing.ImageIcon;

/**
 * @author CXM818
 * 
 * 
 */
public class PlayerObject {
    
    private ImageIcon player_image = new ImageIcon(Class.class.getResource("/rsc/player_1.png"));
    
    public ChinpokemonObject activeChinpokemon = null; // The chinpokemon the player uses for battling
    public final InventoryObject inventory = new InventoryObject(); // The players inventory
    public final String name = "H2O2"; // The players name
    
    public static final AbillityObject RETREAT = new AbillityObject("RETREAT",0,0); // The players special retreat ability
    public static final AbillityObject CAPTURE = new AbillityObject("CAPTURE",0,0); // THe players special capture ability
    
    public ImageIcon getPlayer_image() {
        return player_image;
    }

    public void setPlayer_image(ImageIcon player_image) {
        this.player_image = player_image;
    }
    
    public PlayerObject() {
        inventory.add(new ChinpokeSlurry());
        inventory.add(new Shoe(20) );
        inventory.add(new Cellary(30) );
    }
    
}
