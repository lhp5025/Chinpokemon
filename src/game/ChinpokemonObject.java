/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;

/**
 *
 * @author CXM818
 */
public abstract class ChinpokemonObject {

    //name, img, abillity array, 
    protected final ImageIcon defualt_pos_img = null;
    public String name;
    private double maxHealth;
    private double currentHealth;
    private int power;

    
    
    
    
    public double getDamage(double n) {
        
        return 0;
    }

    public double heal(double n) {

        return 0;
    }

    private void evolve() {

    }

    public void powerUp() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
