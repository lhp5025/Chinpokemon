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
public class Cellary extends ChinpokemonObject{
    public Cellary(String name) {
        super("Cellary", name, new ImageIcon(Class.class.getResource("/rsc/cellary.png")).getImage());
        this.maxHealth = this.power * 10; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Cellary(int _pwer) {
        super("Cellary", "Cellary", new ImageIcon(Class.class.getResource("/rsc/cellary.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 10; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Cellary() {
        super("Cellary", "Cellary", new ImageIcon(Class.class.getResource("/rsc/cellary.png")).getImage());
        this.maxHealth = this.power * 10; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 10; // Increase max health
        this.currentHealth += 10; // Increase current heath
        this.ability.upgrade(1, 1); // Increase abilites power
    }
}
