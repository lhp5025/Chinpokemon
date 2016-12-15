
package game;

import javax.swing.ImageIcon;

/**
 * @author Luke
 * 
 * ChinpokeSlurry : An item in the game
 */
public class ChinpokeSlurry extends ItemObject {

    public ChinpokeSlurry() {
        super("Chinpoke-Slurry",
                "Used to feed Chinpokemon, and makes them more powerfull",
                new ImageIcon(Class.class.getResource("/rsc/slurry.png")).getImage());
    }

    @Override
    public void use(ChinpokemonObject c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
