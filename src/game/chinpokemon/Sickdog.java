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
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Sickdog(int _pwer) {
        super("Sickdog", "Sickdog", new ImageIcon(Class.class.getResource("/rsc/sickdog.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 2; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Sickdog() {
        super("Sickdog", "Sickdog", new ImageIcon(Class.class.getResource("/rsc/sickdog.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 1; // Increase max health
        this.currentHealth += 1; // Increase current heath
        this.ability.upgrade(5, 1); // Increase abilites power
    }
}