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
public class Deaddog extends ChinpokemonObject{
    public Deaddog(String name) {
        super("Deaddog", name, new ImageIcon(Class.class.getResource("/rsc/deaddog.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Deaddog(int _pwer) {
        super("Deaddog", "Deaddog", new ImageIcon(Class.class.getResource("/rsc/deaddog.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 2; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Deaddog() {
        super("Deaddog", "Deaddog", new ImageIcon(Class.class.getResource("/rsc/deaddog.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 0; // Increase max health
        this.currentHealth += 0; // Increase current heath
        this.ability.upgrade(0, 0); // Increase abilites power
    }
}
