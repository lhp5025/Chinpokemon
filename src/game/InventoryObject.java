/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author CXM818
 */
public class InventoryObject {
    
    private ArrayList<ItemObject> items = new ArrayList<>();
    private ArrayList<ChinpokemonObject> chinpokemons = new ArrayList<>();
    
    public void add(ItemObject _obj){
        items.add(_obj);
    }
    
    public void add(ChinpokemonObject _obj){
        chinpokemons.add(_obj);
    }
    
    public boolean feedChinpokemon(ChinpokemonObject _chpkmn){
        for (ItemObject _obj : items){
            if (_obj.name == "Chinpoke-Slurry") {
                items.remove(_obj);
                _chpkmn.feed();
                return true;
            }
        }
        
        return false;
    }
    
    public boolean renderChinpokemon(ChinpokemonObject _chpkmn){
        if (chinpokemons.contains(_chpkmn)) {
            chinpokemons.remove(_chpkmn);
            items.add(new ChinpokeSlurry());
            return true;
        }
        
        return false;
    }
    
    public void renameChinpokemon(int _index, String _name){
        chinpokemons.get(_index).setName(_name);
    }
    
    public ArrayList<ItemObject> getItems() {
        return this.items;
    }
    public ArrayList<ChinpokemonObject> getChinpokemon() {
        return this.chinpokemons;
    }
}
