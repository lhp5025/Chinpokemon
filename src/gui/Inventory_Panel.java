/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import game.ChinpokemonObject;
import game.GameObject;
import game.ItemObject;
import java.awt.Graphics;

/**
 *
 * @author LHP5025
 */
public class Inventory_Panel extends javax.swing.JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        playerCredits.setText("Credits: " + game_data.player_1.getCredits());
    }

    private final GameObject game_data;

    public Inventory_Panel(GameObject _data_source) {
        game_data = _data_source;
        this.setVisible(true);
        this.setBounds(50, 50, 600, 500);
        initComponents();
        //
        chinpokemonInput.setVisible(false); //! 
        inventoryList.setListData(game_data.player_1.inventory.getItems().toArray());
        chinpokemonList.setListData(game_data.player_1.inventory.getChinpokemon().toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextPane();
        imageOutPanel = new gui.ImagePanel();
        playerCredits = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        chinpokemonPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chinpokemonList = new javax.swing.JList();
        chinpokemonRenderButton = new javax.swing.JButton();
        feedButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();
        chinpokemonInput = new javax.swing.JTextField();
        inventoryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryList = new javax.swing.JList();
        itemUseButton = new javax.swing.JButton();
        itemDeleteButton = new javax.swing.JButton();

        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(600, 500));

        outputText.setEnabled(false);
        outputText.setFocusable(false);
        jScrollPane4.setViewportView(outputText);

        imageOutPanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout imageOutPanelLayout = new javax.swing.GroupLayout(imageOutPanel);
        imageOutPanel.setLayout(imageOutPanelLayout);
        imageOutPanelLayout.setHorizontalGroup(
            imageOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageOutPanelLayout.setVerticalGroup(
            imageOutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        playerCredits.setText("Credits");

        javax.swing.GroupLayout optPanelLayout = new javax.swing.GroupLayout(optPanel);
        optPanel.setLayout(optPanelLayout);
        optPanelLayout.setHorizontalGroup(
            optPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageOutPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(playerCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        optPanelLayout.setVerticalGroup(
            optPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(imageOutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPane.setDoubleBuffered(true);
        tabPane.setRequestFocusEnabled(false);
        tabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPaneStateChanged(evt);
            }
        });

        chinpokemonList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        chinpokemonList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        chinpokemonList.setFocusable(false);
        chinpokemonList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chinpokemonListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(chinpokemonList);

        chinpokemonRenderButton.setText("Render");
        chinpokemonRenderButton.setFocusable(false);
        chinpokemonRenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinpokemonRenderButtonActionPerformed(evt);
            }
        });

        feedButton.setText("Feed");
        feedButton.setFocusable(false);

        renameButton.setText("Rename");
        renameButton.setFocusable(false);
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chinpokemonPanelLayout = new javax.swing.GroupLayout(chinpokemonPanel);
        chinpokemonPanel.setLayout(chinpokemonPanelLayout);
        chinpokemonPanelLayout.setHorizontalGroup(
            chinpokemonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinpokemonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(chinpokemonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chinpokemonRenderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(renameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chinpokemonInput, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        chinpokemonPanelLayout.setVerticalGroup(
            chinpokemonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinpokemonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chinpokemonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(chinpokemonPanelLayout.createSequentialGroup()
                        .addComponent(feedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(renameButton)
                        .addGap(1, 1, 1)
                        .addComponent(chinpokemonInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chinpokemonRenderButton)))
                .addContainerGap())
        );

        tabPane.addTab("Chinpokemon", chinpokemonPanel);

        inventoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        inventoryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inventoryList.setFocusable(false);
        inventoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryList);

        itemUseButton.setText("Use");
        itemUseButton.setFocusable(false);
        itemUseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUseButtonActionPerformed(evt);
            }
        });

        itemDeleteButton.setText("Delete");
        itemDeleteButton.setFocusable(false);
        itemDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemUseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemDeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventoryPanelLayout.createSequentialGroup()
                        .addComponent(itemUseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itemDeleteButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabPane.addTab("Inventory", inventoryPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPane)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabPane))
                .addContainerGap())
        );

        tabPane.getAccessibleContext().setAccessibleName("TabPane");
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryListMouseClicked
        if (inventoryList.getSelectedIndex() != -1) {
            outputText.setText(((ItemObject) inventoryList.getSelectedValue()).description);
            imageOutPanel.setImage(((ItemObject) inventoryList.getSelectedValue()).image);
        }

    }//GEN-LAST:event_inventoryListMouseClicked

    private void itemUseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemUseButtonActionPerformed

    private void itemDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteButtonActionPerformed
        if (inventoryList.getSelectedIndex() != -1) {
            outputText.setText("[" + inventoryList.getSelectedValue() + " deleted]");
            imageOutPanel.setImage(null);
            game_data.player_1.inventory.getItems().remove(inventoryList.getSelectedIndex());
            inventoryList.setListData(game_data.player_1.inventory.getItems().toArray());
        }

    }//GEN-LAST:event_itemDeleteButtonActionPerformed

    private void chinpokemonRenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinpokemonRenderButtonActionPerformed
        // TODO add your handling code here:
        chinpokemonList.setListData(game_data.player_1.inventory.getChinpokemon().toArray());
    }//GEN-LAST:event_chinpokemonRenderButtonActionPerformed

    private void chinpokemonListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chinpokemonListMouseClicked
        if (chinpokemonList.getSelectedIndex() != -1) {
            outputText.setText(
                    "Species: " + ((ChinpokemonObject) chinpokemonList.getSelectedValue()).species
                    + "\nPower: " + ((ChinpokemonObject) chinpokemonList.getSelectedValue()).getPower()
                    + "\nMax Health: " + ((ChinpokemonObject) chinpokemonList.getSelectedValue()).getMaxHealth()
                    + "\nHealth: " + ((ChinpokemonObject) chinpokemonList.getSelectedValue()).getCurrentHealth());
            imageOutPanel.setImage(((ChinpokemonObject) chinpokemonList.getSelectedValue()).getImageDefault());
        }
    }//GEN-LAST:event_chinpokemonListMouseClicked

    private void tabPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPaneStateChanged
        outputText.setText("");
        imageOutPanel.setImage(null);
        inventoryList.setListData(game_data.player_1.inventory.getItems().toArray());
        chinpokemonList.setListData(game_data.player_1.inventory.getChinpokemon().toArray());
    }//GEN-LAST:event_tabPaneStateChanged

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        String input = chinpokemonInput.getText();
        if (chinpokemonList.getSelectedIndex() != -1) {
            if (chinpokemonInput.isVisible()) {
                if (input.length() > 1 && input != "  ") {
                    game_data.player_1.inventory.renameChinpokemon(chinpokemonList.getSelectedIndex(), input);
                    chinpokemonInput.setText("");
                    game_data.requestFocus();
                    chinpokemonInput.setVisible(false);
                    renameButton.setText("Rename");
                } else {
                    renameButton.setText("Rename");
                    game_data.requestFocus();
                    chinpokemonInput.setVisible(false);
                }
            } else {
                renameButton.setText("Enter");
                chinpokemonInput.setVisible(true);
            }

        }

    }//GEN-LAST:event_renameButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chinpokemonInput;
    private javax.swing.JList chinpokemonList;
    private javax.swing.JPanel chinpokemonPanel;
    private javax.swing.JButton chinpokemonRenderButton;
    private javax.swing.JButton feedButton;
    private gui.ImagePanel imageOutPanel;
    private javax.swing.JList inventoryList;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JButton itemDeleteButton;
    private javax.swing.JButton itemUseButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel optPanel;
    private javax.swing.JTextPane outputText;
    private javax.swing.JLabel playerCredits;
    private javax.swing.JButton renameButton;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
