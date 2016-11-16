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
public abstract class ItemObject{
    
    
    
    public final String name;
    
    public abstract void use();
    
    public ItemObject (String _name) {
        this.name = _name;
    }
    
}
