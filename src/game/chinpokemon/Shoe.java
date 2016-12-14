/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.chinpokemon;
import game.AbillityObject;
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
        this.maxHealth = this.power * 25; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Stomp", this.power * 3, 0);
    }
    
    public Shoe(int _pwer) {
        super("Shoe", "Shoe", new ImageIcon(Class.class.getResource("/rsc/shoe.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 25; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Stomp", this.power * 3, 0);
    }
    
    public Shoe() {
        super("Shoe", "Shoe", new ImageIcon(Class.class.getResource("/rsc/shoe.png")).getImage());
        this.maxHealth = this.power * 25; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Stomp", this.power * 3, 0);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 25; // Increase max health
        this.currentHealth += 25; // Increase current heath
        this.ability.upgrade(3, 0); // Increase abilites power
    }
    
}
