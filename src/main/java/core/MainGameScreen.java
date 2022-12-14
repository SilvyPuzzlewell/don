/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Ronald
 */
public class MainGameScreen extends javax.swing.JFrame {

    private MainGame mainGame;
    private InventoryScreen invScreen;

    /**
     * Creates new form MainGameScreen
     */
    public MainGameScreen() {
        mainGame = new MainGame(GameCore.getMainCharacter());
        initComponents();
    }

    private class PickListener implements ActionListener {

        private final Item item;

        public PickListener(Item item) {
            this.item = item;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            GameLog.append(mainGame.pick(item));

            ArrayList<String> appendList = mainGame.opponentTurn();
            if (appendList != null) {
                if (!appendList.isEmpty()) {
                    for (String append : appendList) {
                        GameLog.append(append);
                        if (append.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())) {
                            mainGame.exitGameDead();
                        }
                    }
                }
            }
        }
    }

    private class StrikeListener implements ActionListener {

        private final Weapon weapon;
        private final NPC npc;

        public StrikeListener(Weapon weapon, NPC npc) {
            this.weapon = weapon;
            this.npc = npc;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String message = mainGame.mainCharacterAttacs(npc);
            GameLog.append(message);
            ArrayList<String> appendList = mainGame.opponentTurn();
            if (appendList != null) {
                if (!appendList.isEmpty()) {
                    for (String append : appendList) {
                        GameLog.append(append);
                        if (append.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())) {
                            mainGame.exitGameDead();
                        }
                    }
                }
            }
        }

    }

    private JPopupMenu initPickMenu() {
        JPopupMenu menuActual = new JPopupMenu();
        ArrayList<Item> cur = mainGame.pick();
        if (cur == null) {
            return null;
        }
        int i = 0;
        for (Item subMenuItem : cur) {
            JMenuItem item = new JMenuItem("Pick: " + subMenuItem.getName());
            item.addActionListener(new PickListener(subMenuItem));
            menuActual.add(item);

        }
        return menuActual;
    }

    private JPopupMenu initStrikeMenu() {
        JPopupMenu menuActual = new JPopupMenu();
        ArrayList<NPC> cur = mainGame.getHostiles();
        if (cur == null) {
            return null;
        }
        int i = 0;
        for (NPC subMenuItem : cur) {
            JMenuItem item = new JMenuItem("Pick: " + subMenuItem.getName());
            item.addActionListener(new StrikeListener(mainGame.getMainCharEqWeapon(), subMenuItem));
            menuActual.add(item);

        }
        return menuActual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        GameLog = new javax.swing.JTextArea();
        inventoryScreenButton = new javax.swing.JButton();
        examineButton = new javax.swing.JButton();
        characterInfoButton = new javax.swing.JButton();
        saveGameButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        moveNorthButton = new javax.swing.JButton();
        moveWestButton = new javax.swing.JButton();
        moveSouthButton = new javax.swing.JButton();
        moveEastButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        strikeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GameLog.setBackground(new java.awt.Color(0, 0, 102));
        GameLog.setColumns(20);
        GameLog.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GameLog.setForeground(new java.awt.Color(255, 255, 255));
        GameLog.setLineWrap(true);
        GameLog.setRows(5);
        jScrollPane1.setViewportView(GameLog);

        inventoryScreenButton.setText("inventory");
        inventoryScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryScreenButtonActionPerformed(evt);
            }
        });

        examineButton.setText("examine");
        examineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examineButtonActionPerformed(evt);
            }
        });

        characterInfoButton.setText("character");
        characterInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterInfoButtonActionPerformed(evt);
            }
        });

        saveGameButton.setText("save game");
        saveGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameButtonActionPerformed(evt);
            }
        });

        moveNorthButton.setText("north");
        moveNorthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveNorthButtonActionPerformed(evt);
            }
        });

        moveWestButton.setText("west");
        moveWestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveWestButtonActionPerformed(evt);
            }
        });

        moveSouthButton.setText("south");
        moveSouthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveSouthButtonActionPerformed(evt);
            }
        });

        moveEastButton.setText("east");
        moveEastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveEastButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("move");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(moveNorthButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(moveSouthButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moveWestButton, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(moveEastButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moveWestButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(moveNorthButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveSouthButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(moveEastButton))
                .addContainerGap())
        );

        jButton2.setText("pick");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        strikeButton.setText("strike");
        strikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strikeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(examineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventoryScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(characterInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(strikeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveGameButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(characterInfoButton)
                            .addComponent(examineButton)
                            .addComponent(strikeButton))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveGameButton)
                            .addComponent(inventoryScreenButton)
                            .addComponent(jButton2))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void moveAction(int direction) {
    	if (!GameCore.isFighting()) {
    		GameLog.append(mainGame.move(direction));
    	} else {
    		GameLog.append(mainGame.CANT_RUN_WHILE_FIGHTING_MESSAGE);
    	}
        ArrayList<String> appendList = mainGame.opponentTurn();
        if (appendList != null) {
            if (!appendList.isEmpty()) {
                for (String append : appendList) {
                    GameLog.append(append);
                    if (append.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())) {
                        mainGame.exitGameDead();

                    }
                }
            }
        }
    }
    
    // </editor-fold>//GEN-END:initComponents
    //move north
    private void moveNorthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveNorthButtonActionPerformed
    	moveAction(1);

    }//GEN-LAST:event_moveNorthButtonActionPerformed
    //move west
    private void moveWestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveWestButtonActionPerformed
    	moveAction(2);
    }//GEN-LAST:event_moveWestButtonActionPerformed
    //move south
    private void moveSouthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveSouthButtonActionPerformed
    	moveAction(3);

    }//GEN-LAST:event_moveSouthButtonActionPerformed
    //move east
    private void moveEastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveEastButtonActionPerformed
    	moveAction(4);
    }//GEN-LAST:event_moveEastButtonActionPerformed

    private void examineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examineButtonActionPerformed
        //GameLog.append(mainGame.getDescription());
        ArrayList<String> appendList1 = mainGame.examine();
        if (!appendList1.isEmpty()) {
            for (String append : appendList1) {
                GameLog.append(append);
            }
        }
        ArrayList<String> appendList2 = mainGame.opponentTurn();
        if (appendList2 != null) {
            if (!appendList2.isEmpty()) {
                for (String append : appendList2) {
                    GameLog.append(append);
                    if (append.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())) {
                        mainGame.exitGameDead();
                    }
                }
            }
        }

    }//GEN-LAST:event_examineButtonActionPerformed
    //Acess Inventory
    private void inventoryScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryScreenButtonActionPerformed

        invScreen = new InventoryScreen(this, true, new InventoryScreenModel());
        invScreen.setVisible(true);
        ArrayList<String> appendList = mainGame.opponentTurn();
        if (appendList != null) {
            if (!appendList.isEmpty()) {
                for (String append : appendList) {
                    GameLog.append(append);
                    if (append.equals(CriticalStringMessage.MAIN_CHARACTER_KILLED.getMessage())) {
                        mainGame.exitGameDead();
                    }
                }
            }
        }

    }//GEN-LAST:event_inventoryScreenButtonActionPerformed

    private void saveGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameButtonActionPerformed
        mainGame.saveGame();
    }//GEN-LAST:event_saveGameButtonActionPerformed

    private void characterInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_characterInfoButtonActionPerformed
        CharacterInfoScreen chis = new CharacterInfoScreen(this, true);
        chis.setVisible(true);
    }//GEN-LAST:event_characterInfoButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JPopupMenu menu = initPickMenu();
        if (menu == null) {
            return;
        }
        menu.show((Component) evt.getSource(), 0, 0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void strikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strikeButtonActionPerformed
        JPopupMenu menu = initStrikeMenu();
        if (menu == null) {
            return;
        }
        menu.show((Component) evt.getSource(), 0, 0);
    }//GEN-LAST:event_strikeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea GameLog;
    private javax.swing.JButton characterInfoButton;
    private javax.swing.JButton examineButton;
    private javax.swing.JButton inventoryScreenButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moveEastButton;
    private javax.swing.JButton moveNorthButton;
    private javax.swing.JButton moveSouthButton;
    private javax.swing.JButton moveWestButton;
    private javax.swing.JButton saveGameButton;
    private javax.swing.JButton strikeButton;
    // End of variables declaration//GEN-END:variables
}
