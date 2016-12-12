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
public class Slg_al extends ChinpokemonObject {
    public Slg_al(String name) {
        super("Slg'al", name, new ImageIcon(Class.class.getResource("/rsc/essenceof_slg'al.png")).getImage());
        this.ability = new AbillityObject("DOOM!", this.power * 7, 1);
    }
    
    public Slg_al(int _pwer) {
        super("Slg'al", "Essence of Slg'al", new ImageIcon(Class.class.getResource("/rsc/essenceof_slg'al.png")).getImage());
        this.power = _pwer;
        this.maxHealth = this.power * 10; 
        this.currentHealth =  this.maxHealth;
        this.ability = new AbillityObject("DOOM!", this.power * 7, 1);
    }
    
    public Slg_al() {
        super("Slg'al", "Essence of Slg'al", new ImageIcon(Class.class.getResource("/rsc/essenceof_slg'al.png")).getImage());
        this.ability = new AbillityObject("DOOM!", this.power * 7, 1);
    }

    @Override
    public void feed() {
        this.power++; // Increase power level
        this.maxHealth += 10; // Increase max health
        this.currentHealth += 10; // Increase current heath
        this.ability.upgrade(7, 0); // Increase abilites power
    }
}
