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
    private final Image overflow_image = new ImageIcon(Class.class.getResource("/rsc/shrub_basic.png")).getImage();
    private int delta_width = 0;
    private int delta_height = 0;
    private final RenderingHints render_hints;
    private Graphics2D g2;
    private WorldTile[][] zone_tiles;
    private Image player_image;
    
    public long render_time = 0;
    public int zoom_level = 6; //# of blocks displayed in the max direction

    public GamePanel(GameObject _data_source) {
        game_date = _data_source;
        this.setVisible(true);
        this.setSize(game_date.getWidth(), game_date.getHeight());
        this.setDoubleBuffered(true);
        
        player_image = game_date.getPlayer().getPlayer_image().getImage();
        
        render_hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR );
        render_hints.add(new RenderingHints( RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY ));
    }
    
    public void zoom(int delta) {
        if (delta < 0 && zoom_level > 2) {
            zoom_level -= 2;
        } else if (zoom_level < 24 && delta > 0) {
            zoom_level += 2;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        long start_time = System.currentTimeMillis();
        super.paint(g);
        this.setSize(game_date.getWidth(), game_date.getHeight());
        g2 = (Graphics2D) g;
        
        g2.setRenderingHints(render_hints);
        
        g2.drawImage(background_image, 0, 0, game_date.getWidth(),
                game_date.getHeight(), this); // Draw background image first
        
        zone_tiles = game_date.world.getCurrent_zone().getZone_tiles();

        //int tile_draw_size = Math.max(this.getHeight(), this.getWidth()) / zoom_level;
        int tile_draw_size = this.getWidth() / zoom_level;
        delta_width = (int) ((Math.floor(game_date.world.getPlayer_location().getX()) - game_date.world.getPlayer_location().getX()) * (tile_draw_size * 1.0));
        delta_height = (int) ((Math.floor(game_date.world.getPlayer_location().getY()) - game_date.world.getPlayer_location().getY()) * (tile_draw_size * 1.0));
        int offset_x = zoom_level / 2 * tile_draw_size;
        int offset_y = zoom_level / 2 * tile_draw_size * this.getHeight() / this.getWidth();// bc tile count is width dep
        
        for (int y = zoom_level / -2 - 1; y <= zoom_level / 2 + 1; y++) {
            for (int x = zoom_level / -2 - 1; x <= zoom_level / 2 + 1; x++) {
                try {
                    g2.drawImage(zone_tiles[x + (int) game_date.world.getPlayer_location().getX()][y + (int) game_date.world.getPlayer_location().getY()].getBg_image(),
                            x * tile_draw_size + delta_width + offset_x, y * tile_draw_size + delta_height + offset_y,
                            tile_draw_size,
                            tile_draw_size,
                            null);
                } catch (Exception e) {
                    g2.drawImage(overflow_image,
                            x * tile_draw_size + delta_width + offset_x, y * tile_draw_size + delta_height + offset_y,
                            tile_draw_size,
                            tile_draw_size,
                            null);
                }
            }
        }

        // Draw Player
        g2.drawImage(player_image,
                offset_x - tile_draw_size / 2, offset_y - tile_draw_size,
                tile_draw_size,
                tile_draw_size,
                null);
        
        
        g2.dispose();
        render_time = System.currentTimeMillis() - start_time;
    }
    
}
