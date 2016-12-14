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
public class Cherry extends ChinpokemonObject{
    public Cherry(String name) {
        super("Cherry", name, new ImageIcon(Class.class.getResource("/rsc/_cherry.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Cherry(int _pwer) {
        super("Cherry", "Cherry", new ImageIcon(Class.class.getResource("/rsc/_cherry.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 2; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }
    
    public Cherry() {
        super("Cherry", "Cherry", new ImageIcon(Class.class.getResource("/rsc/_cherry.png")).getImage());
        this.ability = new AbillityObject("Attack", this.power * 1, this.power * 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 3; // Increase max health
        this.currentHealth += 5; // Increase current heath
        this.ability.upgrade(2, 2); // Increase abilites power
    }
}
