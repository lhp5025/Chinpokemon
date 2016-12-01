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
public abstract class AbillityObject{
    public final int damage;
    public final int helaing;
    public final String name;
    
    public AbillityObject(String _name, int _dmg, int _heal) {
        this.name = _name;
        this.damage = _dmg;
        this.helaing = _heal;
    }
    
}
