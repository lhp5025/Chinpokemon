/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import game.GameObject;
import game.Vector;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
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
    private Vector player_location = new Vector(0.0, 0.0);

    private boolean collisionDetection(double x, double y) {
        return false;
    }

    public void movePlayer(Vector _input) {
        double movement_speed = 0.005 * game_data.getDelta_time();
        double magnitude = Math.sqrt(_input.getX() * _input.getX() + _input.getY() * _input.getY());

        if (magnitude != 0) {
            Point2D normal = new Point.Double(_input.getX() / magnitude, _input.getY() / magnitude);
            if (player_location.getX() + normal.getX() * movement_speed >= 0.0 && player_location.getY() + normal.getY() * movement_speed >= 0.0) {
                player_location.incLocation(normal.getX() * movement_speed, normal.getY() * movement_speed);
            }

        }

    }

    public Vector getPlayer_location() {
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
        Zone importZone;
        try {
                ObjectInputStream in = new ObjectInputStream(Class.class.getResourceAsStream("/rsc/testZone.zone"));
                importZone = (Zone) in.readObject();
                current_zone = importZone;
            } catch (Exception e) {
                e.printStackTrace();
            }

        
    }
}
