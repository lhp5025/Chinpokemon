
package game;

/**
 * @author CXM818
 * 
 * Ability Object : For Chinpokemon battling
 */
public class AbillityObject{
    private int damage; // The damage to the enemy that the ability does
    private int helaing; // The healing to the user of the ability
    public final String name; // The name of the ability    
    
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
    
    // Increase the power of the ability
    public void upgrade(int _dmg, int _heal) {
        this.damage += _dmg;
        this.helaing += _heal;
    }
    
    @Override
    public String toString() {
        return this.name + "\n  (D=" + this.damage + ";" + " H=" + this.helaing + ")";
    }
}
