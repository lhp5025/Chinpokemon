/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import game.GameObject;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public class World {

    private final GameObject game_data;
    private ArrayList<Zone> zones = new ArrayList<>();
    private Zone current_zone;
    private Point2D player_location = new Point2D.Double(0.0, 0.0);

    private boolean collisionDetection(double x, double y) {
        return false;
    }

    public void movePlayer(Point2D _input) {
        double movement_speed = 0.005 * game_data.getDelta_time();
        double magnitude = Math.sqrt(_input.getX() * _input.getX() + _input.getY() * _input.getY());

        if (magnitude != 0) {
            Point2D normal = new Point.Double(_input.getX() / magnitude, _input.getY() / magnitude);
            if (player_location.getX() + normal.getX() * movement_speed >= 0.0 && player_location.getY() + normal.getY() * movement_speed >= 0.0) {
                player_location.setLocation(player_location.getX() + normal.getX() * movement_speed,
                        player_location.getY() + normal.getY() * movement_speed);
            }

        }

    }

    public Point2D getPlayer_location() {
        return player_location;
    }

    public Zone getCurrent_zone() {
        return current_zone;
    }

    //!! Temp
    private final FloorTile grass1 = new FloorTile(new ImageIcon(Class.class.getResource("/rsc/grass_1.png")));
    private final FloorTile grass2 = new FloorTile(new ImageIcon(Class.class.getResource("/rsc/grass_2.png")));
    private final FloorTile grass3 = new FloorTile(new ImageIcon(Class.class.getResource("/rsc/grass_3.png")));

    //!! 
    public World(GameObject _game_data) {
        game_data = _game_data;
        WorldTile[][] temp_test = new WorldTile[32][32];

        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < 32; j++) {
                if (i % 2 == 0) {
                    temp_test[i][j] = grass1;
                } else if (j % 3 == 0) {
                    temp_test[i][j] = grass3;
                } else {
                    temp_test[i][j] = grass2;
                }
            }
        }

        current_zone = new Zone("temp", temp_test);
    }
}
