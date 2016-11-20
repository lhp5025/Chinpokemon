package builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import world.WorldTile;

/**
 * Displays and updates two-dimensional array of WorldTiles
 */
public class WorldBuilderPanel extends JPanel{
    
    private WorldTile chosenTile;
    public WorldTile[][] worldArray;
    private final int BLOCK_SIZE = 32;
    
    public WorldBuilderPanel(WorldTile[][] worldArray) {
        super();
        this.setSize( new Dimension( worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE) );
        this.setPreferredSize(new Dimension( worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE));
        this.setVisible(true);
        this.addMouseListener(new MouseClicky(this));
        this.setAutoscrolls(true);
        this.setBackground(Color.red);
        this.worldArray = worldArray;
        
    }
    
    public void setCurrentTile(WorldTile _tile) {
        this.chosenTile = _tile;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int x = 0; x < worldArray.length; x++ ){
            for(int y = 0; y < worldArray[x].length; y++ ){
                g.drawImage(worldArray[x][y].getBg_image(), x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, this);
            }
        }
    }
    
    
    public class MouseClicky implements MouseListener {
        public final JComponent parent;
        
        public MouseClicky(JComponent _parent){
            parent = _parent;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
           if(chosenTile != null) {
                int x = e.getX();
                int y = e.getY();
                x = (int) Math.floor(x / BLOCK_SIZE);
                y = (int) Math.floor(y / BLOCK_SIZE);
                worldArray[x][y] = chosenTile;
                parent.repaint();
           }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
