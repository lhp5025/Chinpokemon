/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.GameObject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import world.*;

/**
 * Class.class.getResource("/RSC/water_a1.gif")).getImage()
 *
 * @author LHP5025
 */
public class GamePanel extends JPanel {

    private final GameObject game_date;
    private final Image background_image = new ImageIcon(Class.class.getResource("/rsc/world_bg_1.png")).getImage();
    private int delta_width = 0;
    private int delta_height = 0;

    public long render_time = 0;
    public int zoom_level = 5; //# of blocks displayed in the max direction

    public GamePanel(GameObject _data_source) {
        game_date = _data_source;
        this.setVisible(true);
        this.setSize(game_date.getWidth(), game_date.getHeight());
        this.setDoubleBuffered(true);
    }
    
    public void zoom(int delta){
        if (delta < 0 && zoom_level > 2) {
            zoom_level--;
        } else if (zoom_level < 12 && delta > 0 ) {
            zoom_level++;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        long start_time = System.currentTimeMillis();

        this.setSize(game_date.getWidth(), game_date.getHeight());
        Graphics2D g2 = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.setRenderingHints(rh);

        g2.drawImage(background_image, 0, 0, game_date.getWidth(), game_date.getHeight(), this); // Draw background image first

        WorldTile[][] zone_tiles = game_date.world.getCurrent_zone().getZone_tiles();

        int tile_draw_size = Math.max(this.getHeight(), this.getWidth()) / zoom_level;

        delta_width = (int) ((Math.floor(game_date.world.getPlayer_location().getX()) - game_date.world.getPlayer_location().getX()) * (tile_draw_size * 1.0));
        delta_height = (int) ((Math.floor(game_date.world.getPlayer_location().getY()) - game_date.world.getPlayer_location().getY()) * (tile_draw_size * 1.0));
        
        //System.out.println(delta_width);
        for (int y = -1; y < zoom_level + 2; y++) {
            for (int x = -1; x < zoom_level + 2; x++) {
                try {
                    g2.drawImage(zone_tiles[x + (int) game_date.world.getPlayer_location().getX()][y + (int) game_date.world.getPlayer_location().getY()].getBg_image(),
                            x * tile_draw_size + delta_width, y * tile_draw_size + delta_height, tile_draw_size, tile_draw_size, null);
                } catch (Exception e) {
                }
            }
        }

        render_time = System.currentTimeMillis() - start_time;
    }

}
