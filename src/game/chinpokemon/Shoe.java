/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.chinpokemon;
import game.ChinpokemonObject;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Luke
 */
public class Shoe extends ChinpokemonObject {
    
    public Shoe(String name) {
        super("Shoe", name, new ImageIcon(Class.class.getResource("/rsc/shoe.png")).getImage());
    }
    
    public Shoe(int _pwer) {
        super("Shoe", "Shoe", new ImageIcon(Class.class.getResource("/rsc/shoe.png")).getImage());
        this.power = _pwer;
        this.maxHealth += this.power * 5; 
        this.currentHealth =  this.maxHealth;
    }
    
    public Shoe() {
        super("Shoe", "Shoe", new ImageIcon(Class.class.getResource("/rsc/shoe.png")).getImage());
    }

    @Override
    public void feed() {
        this.power++;
        this.maxHealth += this.power * 5; 
    }
    
}
