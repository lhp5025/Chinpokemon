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
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author LHP5025
 */
public class World {

    private final GameObject game_data;
    private ArrayList<Zone> zones = new ArrayList<>();
    private Zone current_zone;
    private Vector player_location = new Vector(2.0, 2.0);
    
    Random generator = new Random();

    private boolean collisionDetection(double x, double y) {
        return false;
    }

    public void movePlayer(Vector _input) {
        double movement_speed = .15 * game_data.getTheta_time();
        double magnitude = Math.sqrt(_input.getX() * _input.getX() + _input.getY() * _input.getY());

        if (magnitude != 0) {
            Point2D normal = new Point.Double(_input.getX() / magnitude, _input.getY() / magnitude);

            // If collision checks out
            if (checkCollision(new Vector(player_location.getX() + normal.getX() * movement_speed, player_location.getY() + normal.getY() * movement_speed))) {
                player_location.incLocation(normal.getX() * movement_speed, normal.getY() * movement_speed);
               
               //Generate a number between 0 and 9999
               int randomEncounterNumber = generator.nextInt(10000);
               //Get the encounter probability based on the tile player is on
               TileProbability tp = (TileProbability) current_zone.getTileProbabilities().get(current_zone.getZone_tiles()[(int) Math.floor(player_location.getX())][(int) Math.floor(player_location.getY())].BG_IMGICON_MAP);
               //If the generated number is less than the encounter probability number
               if(randomEncounterNumber < tp.encounterProbability) {
                    //Generate another random number to see which pokemon player will encounter
                    randomEncounterNumber = generator.nextInt(10000);
                    System.out.println(tp.map.floorEntry(randomEncounterNumber).getValue());
               }
            }

        }

    }

    private boolean checkCollision(Vector _pos) {
        try {
            // If the current tile is a floor (i.e. it doesn not enact collision)
            if (current_zone.getZone_tiles()[(int) Math.floor(_pos.getX())][(int) Math.floor(_pos.getY())].type.equals("FLOOR")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        /*if (current_zone.getZone_tiles()[(int) Math.floor(_pos.getX())][(int) Math.floor(_pos.getY())].type == "WALL"
                && _pos.getX() > 0.0 && _pos.getX() <= current_zone.width
                && _pos.getY() > 0.0 && _pos.getY() <= current_zone.heihgt) {
            return false;
        }*/
        return false;
    }

    public Vector getPlayer_location() {
        return player_location;
    }

    public Zone getCurrent_zone() {
        return current_zone;
    }

    //!! 
    public World(GameObject _game_data) {
        game_data = _game_data;
        WorldTile[][] temp_test = new WorldTile[32][32];
        Zone importZone;
        try {
            ObjectInputStream in = new ObjectInputStream(Class.class.getResourceAsStream("/rsc/zoneTest.zone"));
            importZone = (Zone) in.readObject();
            current_zone = importZone;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
