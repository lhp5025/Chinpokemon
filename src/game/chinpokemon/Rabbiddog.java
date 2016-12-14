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
public class Rabbiddog extends ChinpokemonObject{
    public Rabbiddog(String name) {
        super("Rabbiddog", name, new ImageIcon(Class.class.getResource("/rsc/rabbiddog.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Rabbiddog(int _pwer) {
        super("Rabbiddog", "Rabbiddog", new ImageIcon(Class.class.getResource("/rsc/rabbiddog.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 2; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Rabbiddog() {
        super("Rabbiddog", "Rabbiddog", new ImageIcon(Class.class.getResource("/rsc/rabbiddog.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 6; // Increase max health
        this.currentHealth += 6; // Increase current heath
        this.ability.upgrade(6, 6); // Increase abilites power
    }
}