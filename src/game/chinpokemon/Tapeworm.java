/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.chinpokemon;

import game.AbillityObject;
import game.ChinpokemonObject;
import javax.swing.ImageIcon;

/**
 *
 * @author Luke
 */
public class Tapeworm extends ChinpokemonObject{
    public Tapeworm(String name) {
        super("Tapeworm", name, new ImageIcon(Class.class.getResource("/rsc/tapeworm.png")).getImage());
        this.maxHealth = this.power * 30; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 5);
    }
    
    public Tapeworm(int _pwer) {
        super("Tapeworm", "Tapeworm", new ImageIcon(Class.class.getResource("/rsc/tapeworm.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 30; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 5);
    }
    
    public Tapeworm() {
        super("Tapeworm", "Tapeworm", new ImageIcon(Class.class.getResource("/rsc/tapeworm.png")).getImage());
        this.maxHealth = this.power * 30; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 5);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 15; // Increase max health
        this.currentHealth += 15; // Increase current heath
        this.ability.upgrade(5, 5); // Increase abilites power
    }
}
