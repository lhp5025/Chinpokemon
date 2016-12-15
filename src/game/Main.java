
package game;

import javax.swing.UIManager;

/**
 * @author LHP5025
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True"); // Open OpenGL pipleing to help improve performance

        try {
            // Set cross-platform Java look and feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("WARNING: Lood and feel not set");
        }

        GameObject g = new GameObject(); // Start game

    }

}
