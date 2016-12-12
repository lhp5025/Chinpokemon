/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.chinpokemon.*;
import javax.swing.ImageIcon;

/**
 *
 * @author CXM818
 */
public class PlayerObject {
    
    private ImageIcon player_image = new ImageIcon(Class.class.getResource("/rsc/player_1.png"));
    
    public ChinpokemonObject activeChinpokemon = null; // The chinpokemon the player uses for battling
    public final InventoryObject inventory = new InventoryObject();
    public final String name = "Animu";
    
    public static final AbillityObject RETREAT = new AbillityObject("RETREAT",0,0); // The players special retreat ability
    public static final AbillityObject CAPTURE = new AbillityObject("CAPTURE",0,0); // THe players special capture ability
    
    private long credits = 10;
    
    public ImageIcon getPlayer_image() {
        return player_image;
    }

    public void setPlayer_image(ImageIcon player_image) {
        this.player_image = player_image;
    }
    
    public long getCredits() {
        return this.credits;
    }
    
    
    public PlayerObject() {
        inventory.add(new ChinpokeSlurry());
        inventory.add(new Shoe() );
        inventory.add(new Shoe(10) );
    }
    
}
