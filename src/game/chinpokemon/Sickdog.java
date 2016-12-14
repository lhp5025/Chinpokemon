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
public class Sickdog extends ChinpokemonObject{
    public Sickdog(String name) {
        super("Sickdog", name, new ImageIcon(Class.class.getResource("/rsc/sickdog.png")).getImage());
        this.maxHealth = this.power * 20; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 4, this.power * 0);
    }
    
    public Sickdog(int _pwer) {
        super("Sickdog", "Sickdog", new ImageIcon(Class.class.getResource("/rsc/sickdog.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 20; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 4, this.power * 0);
    }
    
    public Sickdog() {
        super("Sickdog", "Sickdog", new ImageIcon(Class.class.getResource("/rsc/sickdog.png")).getImage());
        this.maxHealth = this.power * 20; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 4, this.power * 0);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 5; // Increase max health
        this.currentHealth += 5; // Increase current heath
        this.ability.upgrade(4, 0); // Increase abilites power
    }
}