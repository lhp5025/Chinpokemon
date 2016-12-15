
package world;

import game.ChinpokemonObject;
import game.GameObject;
import game.Vector;
import game.chinpokemon.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author LHP5025
 * 
 * World Object : for managing the zone, player, collision, movement, and encounters
 */
public class World {

    private final GameObject game_data; // The parent game object
    private Zone current_zone; // The current zone of the world
    private Vector player_location = new Vector(4.0, 4.0); // The players posision in the world
    
    // Method for movieing the player
    /// A vecor is passed for the players velocity
    /// the vector is then normalized and multipled by the players movement speed
    /// and teh players posision is adjusted accordingly
    //// Checks for collions
    ///// Checks for Chinpokemon ecnounters
    public void movePlayer(Vector _input) {
        // Normalize and multiply
        double movement_speed = .15 * game_data.getTheta_time();
        double magnitude = Math.sqrt(_input.getX() * _input.getX() + _input.getY() * _input.getY());
        
        // If the player wants to move
        if (magnitude != 0) {
            Point2D normal = new Point.Double(_input.getX() / magnitude, _input.getY() / magnitude);

            // If collision checks out
            if (checkCollision(new Vector(player_location.getX() + normal.getX() * movement_speed, player_location.getY() + normal.getY() * movement_speed))) {
                player_location.incLocation(normal.getX() * movement_speed, normal.getY() * movement_speed);
               
               // Check for Encounter
              ChinpokemonObject encountered = getEncounter( (int) Math.floor( player_location.getX() ), (int) Math.floor( player_location.getY() ));
              
              // If there is an encounter
              if (encountered != null) {
                  System.out.println( encountered.toString() );
                  // Start battle
                  game_data.battleSysStart(encountered);
              }
             
               
            }

        }

    }
    
    // Method for checking collision of a position
    private boolean checkCollision(Vector _pos) {
        try {
            // If the current tile is a floor (i.e. it doesn not enact collision)
            if (current_zone.getZone_tiles()[(int) Math.floor(_pos.getX())][(int) Math.floor(_pos.getY())].type.equals("FLOOR")) {
                return true;
            }
        } catch (Exception e) {
            // If out of bounds, don;t move there
            return false;
        }
        return false;
    }

    public Vector getPlayer_location() {
        return player_location;
    }

    public Zone getCurrent_zone() {
        return current_zone;
    }
    
    // Method for determining what Chinpokemon was encountered
    public ChinpokemonObject getEncounter(int x, int y) {
        ChinpokemonObject TO_RETURN = null; // Chinpokemon to return
        
        // If the player is on a dirt or grass tyle
        if ( current_zone.getZone_tiles()[x][y].getName().equals("grass")  || current_zone.getZone_tiles()[x][y].getName().equals("dirt") ) {
            Random rng = new Random(System.currentTimeMillis());
            int encoutnerProbability_1 = rng.nextInt(1000) + 1; // Gen a random number from 1 to 1000
            
            final int max_level = 100; // The max level of spawing chinpokemon
            
            // Uncommon .01% outnerProbability_2chance of encounter
            if (encoutnerProbability_1 % 1000 == 0) {
                int encoutnerProbability_2 = rng.nextInt(4); // Gen a random number to pick the chinpokemon
                
                if (encoutnerProbability_2 == 0) TO_RETURN = new Slg_al( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 1) TO_RETURN = new Deaddog( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 2) TO_RETURN = new Orb( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 3) TO_RETURN = new Rabbiddog( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
            }
            // Common .1% chanceof encounter
            else if (encoutnerProbability_1 % 100 == 0) {
                int encoutnerProbability_2 = rng.nextInt(7);  // Gen a random number to pick the chinpokemon
                
                if (encoutnerProbability_2 == 0) TO_RETURN = new Shoe( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 1) TO_RETURN = new Cellary( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 2) TO_RETURN = new Cherry( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 3) TO_RETURN = new Labtron( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 4) TO_RETURN = new Mushroom( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 5) TO_RETURN = new Sickdog( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
                else if (encoutnerProbability_2 == 6) TO_RETURN = new Tapeworm( rng.nextInt(max_level) + 1); // Return shoe of level 1 to 25
            }
            
        }
        return TO_RETURN;
    }

    // Constructor, load zone from resources
    public World(GameObject _game_data) {
        game_data = _game_data;
        WorldTile[][] temp_test = new WorldTile[32][32];
        Zone importZone;
        try {
            ObjectInputStream in = new ObjectInputStream(Class.class.getResourceAsStream("/rsc/zone_1.zone"));
            importZone = (Zone) in.readObject();
            current_zone = importZone;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
