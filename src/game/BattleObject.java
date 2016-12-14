/*


 */
package game;

import game.chinpokemon.Shoe;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleObject {

    private final GameObject game_data;
    private Thread battle = null;
    private AbillityObject playersAbilityChoice = null;
    private ChinpokemonObject enemy_chinpokemon;
    private ChinpokemonObject player_chinpokemon;
    private Boolean CONTROLLER = false;

    public synchronized  void PlayerAction(AbillityObject _ablty) {

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

    public void newBattle(ChinpokemonObject _enemy, ChinpokemonObject _player) {
        enemy_chinpokemon = _enemy;
        player_chinpokemon = _player;

        battle = new Thread("Battle") {
            @Override
            public synchronized void run() {
                synchronized (battle) {

                    boolean winner = false;
                    boolean players_turn = true;

                    // Handle Turns        
                    while (!winner) {
                        if (players_turn) {
                            // Players Turn
                            try {
                                battle.wait(); // Wait for players input
                            } catch (InterruptedException ex) {
                                Logger.getLogger(BattleObject.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println(playersAbilityChoice.name.toUpperCase());
                            // Do action
                            // Check if retreat or capture
                            if (playersAbilityChoice.name.toUpperCase().equals("RETREAT")) {
                                winner = true;
                                players_turn = false;
                            } // Check if wanting to capture
                            else if (playersAbilityChoice.name.toUpperCase().equals("CAPTURE")) {
                                int  prob = (int) Math.abs(1.0 - (enemy_chinpokemon.getCurrentHealth() / enemy_chinpokemon.getMaxHealth() )  * 100 ) ;
                                
                                if ( new Random().nextInt(prob) == 1 ){
                                    winner = true;
                                    game_data.player_1.inventory.add(_enemy);
                                    game_data.battleStateChange( "Capture success!" +"\n" );
                                }
                                players_turn = false;
                                game_data.battleStateChange( "Capture failed!" +"\n" );
                                
                            } // Perform ablities actions 
                            else {
                                players_turn = false;
                                // Check if enemy is dead
                                enemy_chinpokemon.damage(playersAbilityChoice.getDamage());
                                player_chinpokemon.heal(playersAbilityChoice.getHealing());
                                game_data.battleStateChange( "You attacked with " + playersAbilityChoice.name 
                                        +" for " + playersAbilityChoice.getDamage() + ", and healed for " + playersAbilityChoice.getHealing() +"\n");
                            }
                            

                        } else {
                            // CPUs Turn
                            // Do Action
                            player_chinpokemon.damage(enemy_chinpokemon.ability.getDamage());
                            enemy_chinpokemon.heal(enemy_chinpokemon.ability.getHealing());
                            players_turn = true;
                            game_data.battleStateChange( "Enemy attacked with " + enemy_chinpokemon.ability.name 
                                        +" for " + enemy_chinpokemon.ability.getDamage() + ", and healed for " + enemy_chinpokemon.ability.getHealing() +"\n");
                            
                        }
                        
                        if (enemy_chinpokemon.getCurrentHealth() <= 0) {
                            winner = true;
                            game_data.player_1.inventory.add(new ChinpokeSlurry() );
                        }
                        
                        if (player_chinpokemon.getCurrentHealth() <= 0) {
                            winner = true;
                            game_data.player_1.inventory.add(new ChinpokeSlurry() );
                            game_data.player_1.inventory.getChinpokemon().remove(player_chinpokemon) ;
                            game_data.player_1.activeChinpokemon = null;
                            game_data.player_1.inventory.add( new Shoe(10) );
                        }
                        
                    }
                    
                    synchronized (game_data) {
                        game_data.battleSysEnd();  
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
