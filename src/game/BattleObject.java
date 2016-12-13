/*


 */
package game;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleObject {

    private final GameObject game_data;
    private Thread battle = null;
    private AbillityObject playersAbilityChoice = null;
    private ChinpokemonObject enemy_chinpokemon;
    private ChinpokemonObject player_chinpokemon;
    
    public void PlayerAction() {
        if ( battle != null && battle.isAlive() ) {
            battle.notify();
        }
    }
    
    public ChinpokemonObject getEnemy() {
        return enemy_chinpokemon;
    }
    
    public ChinpokemonObject getPlayer() {
        return player_chinpokemon;
    }
    
    public void newBattle(ChinpokemonObject _enemy, ChinpokemonObject _player) {
        enemy_chinpokemon = _enemy;
        player_chinpokemon = _player;
        
        battle = new Thread("Battle") {
            @Override
            public synchronized void run() {
                boolean winner = false;
                boolean players_turn = true;
                
                // Handle Turns        
                while (!winner) {
                    if (players_turn) {
                        // Players Turn
                        try {
                            wait(); // Wait for players input
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BattleObject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        // Do action
                        // Check if retreat or capture
                        if (playersAbilityChoice.name.toUpperCase().equals( "RETREAT" ) ) {
                            winner = true;
                        } 
                        // Check if wanting to capture
                        else if (playersAbilityChoice.name.toUpperCase().equals( "CAPTURE" ) ) {
                            winner = true;
                            game_data.player_1.inventory.add(_enemy);
                        }
                        // Perform ablities actions 
                        else {
                            
                            // Check if enemy is dead
                            
                        }
                        
                        
                    } else {
                        // CPUs Turn
                        // Decide Action
                        // Do Action
                    }

                }
            }
        };
        battle.start();

        // Calc Results/Loot
    }

    /*public void newBattle(NPC _enemy) {
        
    }*/
    public BattleObject(GameObject _game_data) {
        this.game_data = _game_data;
    }

}
