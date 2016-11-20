package builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import world.WorldTile;

/**
 * Displays and updates two-dimensional array of WorldTiles
 */
public class WorldBuilderPanel extends JPanel {

    private WorldTile chosenTile;
    public WorldTile[][] worldArray;
    private int BLOCK_SIZE = 32;
    private final RenderingHints render_hints;
    private Graphics2D g2;

    public WorldBuilderPanel(WorldTile[][] worldArray) {
        super();
        this.setSize(new Dimension(worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE));
        this.setPreferredSize(new Dimension(worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE));
        this.setVisible(true);
        this.addMouseListener(new MouseClicky(this));
        this.setAutoscrolls(true);
        
        this.setBackground(Color.red);
        this.worldArray = worldArray;
        render_hints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        render_hints.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED));

    }

    public void setCurrentTile(WorldTile _tile) {
        this.chosenTile = _tile;
    }

    public void setBLOCK_SIZE(int _i) {
        BLOCK_SIZE = _i;
        this.setSize(new Dimension(worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE));
        this.setPreferredSize(new Dimension(worldArray.length * BLOCK_SIZE, worldArray[0].length * BLOCK_SIZE));
        repaint();
    }

    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g2 = (Graphics2D) g;

        g2.setRenderingHints(render_hints);

        for (int x = 0; x < worldArray.length; x++) {
            for (int y = 0; y < worldArray[x].length; y++) {
                g2.drawImage(worldArray[x][y].getBg_image(), x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, this);
            }
        }
    }

    public class MouseClicky implements MouseListener {

        public final JComponent parent;

        public MouseClicky(JComponent _parent) {
            parent = _parent;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (chosenTile != null) {
                int x = e.getX();
                int y = e.getY();
                x = (int) Math.floor(x / BLOCK_SIZE);
                y = (int) Math.floor(y / BLOCK_SIZE);
                worldArray[x][y] = chosenTile;
                repaint();
            }

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
