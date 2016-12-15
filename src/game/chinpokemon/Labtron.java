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
public class Labtron extends ChinpokemonObject{
    public Labtron(String name) {
        super("Labtron", name, new ImageIcon(Class.class.getResource("/rsc/labtron.png")).getImage());
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 3, this.power * 0);
        
    }
    
    public Labtron(int _pwer) {
        super("Labtron", "Labtron", new ImageIcon(Class.class.getResource("/rsc/labtron.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 3, this.power * 0);
    }
    
    public Labtron() {
        super("Labtron", "Labtron", new ImageIcon(Class.class.getResource("/rsc/labtron.png")).getImage());
        this.maxHealth = this.power * 15; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 3, this.power * 0);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 15; // Increase max health
        this.currentHealth += 15; // Increase current heath
        this.ability.upgrade(10, 5); // Increase abilites power
    }
}
