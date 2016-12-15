
package game;

import java.util.ArrayList;

/**
 * @author CXM818
 * 
 * InventoryObject : For managing the player inventory
 */
public class InventoryObject {
    
    private ArrayList<ItemObject> items = new ArrayList<>(); // List of Items
    private ArrayList<ChinpokemonObject> chinpokemons = new ArrayList<>(); // List of Chinpokemon
    
    // Add item to inventory
    public void add(ItemObject _obj){
        items.add(_obj);
    }
    
    // Add Chinpokemon to inventory
    public void add(ChinpokemonObject _obj){
        chinpokemons.add(_obj);
    }
    
    // Feed a chinpokemon, use Chinpokeslurry in items
    public boolean feedChinpokemon(ChinpokemonObject _chpkmn){
        for (ItemObject _obj : items){
            if (_obj.name == "Chinpoke-Slurry") {
                items.remove(_obj);
                _chpkmn.feed();
                return true; // Return true if feeding was sueccessuful
            }
        }
        
        return false; // Return false if feeding was unsueccessuful
    }
    
    // Turn a chinpokemon into Chinpokeslurry
    /// Remove that chinpokemon from the inventory, add Chinpokeslurry
    public boolean renderChinpokemon(ChinpokemonObject _chpkmn){
        if (chinpokemons.contains(_chpkmn)) {
            chinpokemons.remove(_chpkmn);
            items.add(new ChinpokeSlurry());
            return true;
        }
        
        return false;
    }
    
    // Method for renaming chinpokemon
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
