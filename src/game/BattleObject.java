package game;

import game.chinpokemon.Shoe;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CXM818
 *
 * Battle Object : For managing the execution of battles
 */
public class BattleObject {

    private final GameObject game_data; // The regrence to the partent game object
    private Thread battle = null; // The thread used for the exection of the battle
    private AbillityObject playersAbilityChoice = null; // The ability that the player chooses to use
    private ChinpokemonObject enemy_chinpokemon; // The opponenet chinpokemon in the battle
    private ChinpokemonObject player_chinpokemon; // The players chinpokemon in the battle
    private Boolean CONTROLLER = false;

    // The input for the palyer, for their action in the battle
    /// Needs to be synchronized on the battle thread to avoid errors
    public synchronized void PlayerAction(AbillityObject _ablty) {

        if (battle != null && battle.isAlive()) {
            synchronized (battle) {
                playersAbilityChoice = _ablty;
                CONTROLLER = true;
                battle.notify();
            }
        }

    }

    public ChinpokemonObject getEnemy() {
        return enemy_chinpokemon;
    }

    public ChinpokemonObject getPlayer() {
        return player_chinpokemon;
    }

    // Method for starting a new battle
    /// With an enemy and the players Chinpokemon
    public void newBattle(ChinpokemonObject _enemy, ChinpokemonObject _player) {
        enemy_chinpokemon = _enemy;
        player_chinpokemon = _player;

        // Start the new battle thread
        /// Also needs to be synchronized on itself
        battle = new Thread("Battle") {
            @Override
            public synchronized void run() {
                synchronized (battle) {

                    boolean winner = false; // Boolean for managing if there is a winner in the battle
                    boolean players_turn = true; // Boolean for managing if it's the players or CPU's turn

                    // Handle battle, for there not being a winner        
                    while (!winner) {
                        // If it's the players turn
                        if (players_turn) {
                            // Wait for the players input, i.e. they decide their ability
                            try {
                                battle.wait(); // Wait for players input
                            } catch (InterruptedException ex) {
                                Logger.getLogger(BattleObject.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            // Check if retreat or capture
                            /// If not perform the abilits damage and healing atributes
                            if (playersAbilityChoice.name.toUpperCase().equals("RETREAT")) {
                                // If the player elects to retret, end the battle
                                winner = true;
                                players_turn = false;
                            } else if (playersAbilityChoice.name.toUpperCase().equals("CAPTURE")) {
                                // If the player elects to try and capture the enemy Chinpokemon
                                /// Calc. the % chance of capture, based on their missing health
                                int prob = (int) Math.abs(1.0 - (enemy_chinpokemon.getCurrentHealth() / enemy_chinpokemon.getMaxHealth()) * 100);

                                // Gen. a random number, to see if the capture was successfull
                                if (new Random().nextInt(prob) == 1) {
                                    // If the capture was successfull
                                    /// End the battle
                                    winner = true;
                                    game_data.player_1.inventory.add(_enemy);

                                    // Notify the game object, that battle state has changed, w/ msg
                                    game_data.battleStateChange("Capture success!" + "\n");
                                } else {
                                    // If the capture was unsuccessfull
                                    /// End the players turn
                                    players_turn = false;
                                    game_data.battleStateChange("Capture failed!" + "\n");
                                }

                            } else {
                                // If no special action, perform ablities actions 
                                enemy_chinpokemon.damage(playersAbilityChoice.getDamage());
                                player_chinpokemon.heal(playersAbilityChoice.getHealing());
                                
                                // Notify the game object, that battle state has changed, w/ msg
                                game_data.battleStateChange("You attacked with " + playersAbilityChoice.name
                                        + " for " + playersAbilityChoice.getDamage() + ", and healed for " + playersAbilityChoice.getHealing() + "\n");
                               
                                players_turn = false; // End players turn
                            }

                        } else {
                            // CPUs Turn
                            /// Do Action
                            player_chinpokemon.damage(enemy_chinpokemon.ability.getDamage());
                            enemy_chinpokemon.heal(enemy_chinpokemon.ability.getHealing());
                            
                            // Notify the game object, that battle state has changed, w/ msg
                            game_data.battleStateChange("Enemy attacked with " + enemy_chinpokemon.ability.name
                                    + " for " + enemy_chinpokemon.ability.getDamage() + ", and healed for " + enemy_chinpokemon.ability.getHealing() + "\n");
                            
                            players_turn = true; // End cpu's turn

                        }
                        // After each turn
                        /// Check to see if there is a winner
                        
                        // If the enemy is dead, end the battle and give the player a ChinpokeSlurry
                        if (enemy_chinpokemon.getCurrentHealth() <= 0) {
                            winner = true;
                            game_data.player_1.inventory.add(new ChinpokeSlurry());
                        }
                        
                        // If the player is dead, end the battle and give the player a ChinpokeSlurry
                        /// Remove thier dead Chinpokemon from their inventory
                        if (player_chinpokemon.getCurrentHealth() <= 0) {
                            winner = true;
                            game_data.player_1.inventory.add(new ChinpokeSlurry());
                            game_data.player_1.inventory.getChinpokemon().remove(player_chinpokemon);
                            game_data.player_1.activeChinpokemon = null;
                            game_data.player_1.inventory.add(new Shoe(10));
                        }

                    }
                    
                    // At the end of the battle, notify the game object that the battle is over
                    synchronized (game_data) {
                        game_data.battleSysEnd();
                    }

                }

            }
        };
        battle.start(); // Start the battle thread

    }

    public BattleObject(GameObject _game_data) {
        this.game_data = _game_data;
    }

}
