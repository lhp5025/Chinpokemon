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
public class Mushroom extends ChinpokemonObject{
    public Mushroom(String name) {
        super("Mushroom", name, new ImageIcon(Class.class.getResource("/rsc/mushroom.png")).getImage());
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 2);
    }
    
    public Mushroom(int _pwer) {
        super("Mushroom", "Mushroom", new ImageIcon(Class.class.getResource("/rsc/mushroom.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 2);
    }
    
    public Mushroom() {
        super("Mushroom", "Mushroom", new ImageIcon(Class.class.getResource("/rsc/mushroom.png")).getImage());
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 2);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 15; // Increase max health
        this.currentHealth += 15; // Increase current heath
        this.ability.upgrade(1, 2); // Increase abilites power
    }
}
