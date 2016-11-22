/*


 */
package game;

public class BattleObject implements Runnable {

    private final PlayerObject player;

    public void newBattle(ChinpokemonObject _enemy) {
        boolean winner = false;
        boolean players_turn = true;
        // Handle Turns
        while (!winner) {
            if (players_turn) {
                // Players Turn
                // Get input
                // Do action
            } else {
                // CPUs Turn
                // Decide Action
                // Do Action
            }
            
        }
        // Calc Results/Loot

    }

    /*public void newBattle(NPC _enemy) {
        
    }*/
    public BattleObject(PlayerObject _player) {
        this.player = _player;
    }

    @Override
    public void run() {
        // To Do
    }
}
