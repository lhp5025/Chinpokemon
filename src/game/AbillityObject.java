/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author CXM818
 */
public class AbillityObject{
    private int damage;
    private int helaing;
    public final String name;
    
    public int getDamage() {
        return this.damage;
    }
    
    public int getHealing() {
        return this.helaing;
    }
    
    public AbillityObject(String _name, int _dmg, int _heal) {
        this.name = _name;
        this.damage = _dmg;
        this.helaing = _heal;
    }
    
    public void upgrade(int _dmg, int _heal) {
        this.damage += _dmg;
        this.helaing += _heal;
    }
    
    @Override
    public String toString() {
        return this.name + "\n D=" + this.damage + ";" + " H=" + this.helaing;
    }
}
