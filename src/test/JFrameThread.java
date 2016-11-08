/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Luke
 */
public class JFrameThread extends JFrame implements Runnable {
    
    public JFrameThread() {
        this.setSize(600, 800);
        this.setVisible(true);
        this.add(new JButton());
        Thread thd_test = new Thread(this);
        thd_test.start();
    }
    
    
    @Override
    public void run() {
        while(true){
            System.out.println("THREAD RUN");
            
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(JFrameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
