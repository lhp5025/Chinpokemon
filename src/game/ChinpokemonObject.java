
package game;

import java.awt.Image;

/**
 * @author CXM818
 * 
 * ChinpokemonObject : Master parent object for all Chinpokemon
 */
public abstract class ChinpokemonObject {

    private final Image defualt_pos_img; // The default image for the Chinpokemon
    private String name; // The name
    public final String species; // The species
    protected double maxHealth; // The max health
    protected double currentHealth; // The current health
    protected int power; // The current power/level
    public AbillityObject ability = new AbillityObject("ATTACK",1,0); // The default abiltiy

    // Constructor
    public ChinpokemonObject(String _species, String name, Image _img) {
        this.species = _species;
        this.name = name;
        this.defualt_pos_img = _img;
        this.power = 1;
        this.maxHealth = this.currentHealth = 10;
    }
    
    // Method for healing
    /// Can't increase current health over max health
    public void heal(double n) {
        if (n + currentHealth > maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth += n;
        }
    }
    
    public AbillityObject getAbility() {
        return this.ability;
    }

    // Abstract method for feed
    public abstract void feed();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }
    
    public int getPower() {
        return power;
    }
    
    public void damage(double n) {
        currentHealth -= n;
    }
    
    public Image getImageDefault() {
        return this.defualt_pos_img;
    }
    
    @Override
    public String toString() {
        return this.name + "(" + power + ")";
    }
}
