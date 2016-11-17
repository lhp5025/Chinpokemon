/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Image;

/**
 *
 * @author CXM818
 */
public abstract class ItemObject{
    
    public final String name;
    public final String description;
    public final Image image;
    
    public abstract void use(ChinpokemonObject _obj);
    
    public ItemObject (String _name, String _desc, Image _img) {
        this.name = _name;
        this.description = _desc;
        this.image = _img;
    }
    
    public ItemObject (String _name, String _desc) {
        this.name = _name;
        this.description = _desc;
        this.image = null;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
