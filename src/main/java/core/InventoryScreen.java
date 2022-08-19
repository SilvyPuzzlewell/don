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
import javax.swing.JMenuItem;
import javax.swing.*;

/**
 *
 * @author Ronald
 */
public class InventoryScreen extends javax.swing.JDialog {

    Inventory inventory;
    JButton[] itemButtons;
    InventoryScreenModel model;

    private class LockListener implements ActionListener {

        private Key key;
        private LockableObject lobject;

        public LockListener(Key key, LockableObject lobject) {
            this.key = key;
            this.lobject = lobject;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            InventoryLog.append(key.unlock(lobject,GameCore.getMainCharacter()));
        }

    }

    private JMenu createUnlockSubmenu(Key key) {
        JMenu menuActual = new JMenu();
        ArrayList<GameObject> cuObj = GameCore.getActualLevelPointObjects(GameCore.getMainCharacter());
        if (GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()) == null || GameCore.getActualLevelPointObjects(GameCore.getMainCharacter()).isEmpty()) {
            return null;
        }
        menuActual.setText("Unlock object ");
        int i = 0;
        for (GameObject subMenuItem : cuObj) {
            if (subMenuItem.isLockable() && subMenuItem.isLocked()) {
                LockableObject o = (LockableObject) subMenuItem;
                JMenuItem item = new JMenuItem("Unlock " + subMenuItem.getName());
                item.addActionListener(new LockListener(key, o));
                menuActual.add(item);
                i++;               
            }
            }
            if(i == 0){
                return null;

        }
        return menuActual;
    }

    private class DropItemListener implements ActionListener {

        private int index;

        public DropItemListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (GameCore.getYourInventory().size() > index && GameCore.getYourInventory().get(index) != null) {
                Item dropped = GameCore.getYourInventory().drop(index);
                int[] position = GameCore.getPosition(GameCore.getMainCharacter());
                if(GameCore.getObjectsOnLevelPoint(position[0], position[1]) == null){
                    GameCore.getActualLevelPoint(GameCore.getMainCharacter()).setItemsOnPoint(new ArrayList<GameObject>());
                }
                GameCore.getObjectsOnLevelPoint(position[0], position[1]).add(dropped);
                reInitItemButtonsTExt();
            }
        }
    }

    private class EquipWeaponListener implements ActionListener {

        private Weapon weapon;

        public EquipWeaponListener(Weapon weapon) {
            this.weapon = weapon;
            GameCore.getMainCharacter().equipWeapon(weapon);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            GameCore.getMainCharacter().equipWeapon(weapon);
            damageLabel.setText(model.getEquippedWeaponDAmage());
            weaponLabel.setText(model.getEquippedWeaponText());
        }
    }

    private JPopupMenu weaponMenu(Weapon weapon, int index) {
        JPopupMenu weaponPopUp = new JPopupMenu();
        JMenuItem dropItem = new JMenuItem("Drop weapon");
        JMenuItem equipWeapon = new JMenuItem("Equip weapon");

        dropItem.addActionListener(new DropItemListener(index));
        equipWeapon.addActionListener(new EquipWeaponListener(weapon));
        weaponPopUp.add(dropItem);
        weaponPopUp.add(equipWeapon);
        return weaponPopUp;
    }

    private JPopupMenu keyMenu(Key key, int index) {
        JPopupMenu keyPopUp = new JPopupMenu();
        JMenuItem dropItem = new JMenuItem("Drop key");
        JMenu unlock = createUnlockSubmenu(key);

        dropItem.addActionListener(new DropItemListener(index));
        if(unlock != null){        
            keyPopUp.add(unlock);
        }
        keyPopUp.add(dropItem);
        return keyPopUp;
    }

    /**
     * Creates new form InventoryScreen
     */
    public InventoryScreen(java.awt.Frame parent, boolean modal, InventoryScreenModel model) {
        super(parent, modal);
        this.model = model;
        inventory = GameCore.getYourInventory();
        initComponents();
        itemButtons = new JButton[]{Inventory0,Inventory1,Inventory2,Inventory3,Inventory4
                ,Inventory5,Inventory6,Inventory7,Inventory8,Inventory9, Inventory10
                ,Inventory11,Inventory12,Inventory13,Inventory14,Inventory15,Inventory16
                ,Inventory17,Inventory18,Inventory19};
    }

    private String initText(int index) {
        if (GameCore.getYourInventory().size() > index && GameCore.getYourInventory().get(index) != null) {
            return (GameCore.getYourInventory().get(index).getName());
        } else {
            return ("empty");
        }
    }

    private void reInitItemButtonsTExt() {
        for (int i = 0; i < itemButtons.length; i++) {
            itemButtons[i].setText(initText(i));
        }
    }

    private void ButtonStuff(int index, JButton button, ActionEvent evt) {
        if (index >= GameCore.getYourInventory().size()) {
            return;
        }
        Item item = GameCore.getYourInventoryList().get(index);
        switch (item.getItemType()) {
            case MELEEWEAPON:
                Weapon weapon = (Weapon) item;
                JPopupMenu menu = weaponMenu(weapon, index);
                menu.show((Component) evt.getSource(), 0, 0);
                // menu.show(button, button.getBounds().x, button.getBounds().y + button.getBounds().height);
                //button.setComponentPopupMenu(menu);
                break;
            case KEY:
                Key key = (Key) item;
                JPopupMenu kmenu = keyMenu(key, index);
                kmenu.show((Component) evt.getSource(), 0, 0);
                //button.setComponentPopupMenu(kmenu);
                //    kmenu.show(button, button.getBounds().x, button.getBounds().y + button.getBounds().height);
                break;

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        Inventory3 = new javax.swing.JButton();
        Inventory6 = new javax.swing.JButton();
        Inventory10 = new javax.swing.JButton();
        Inventory1 = new javax.swing.JButton();
        Inventory11 = new javax.swing.JButton();
        Inventory5 = new javax.swing.JButton();
        Inventory12 = new javax.swing.JButton();
        Inventory0 = new javax.swing.JButton();
        Inventory2 = new javax.swing.JButton();
        Inventory7 = new javax.swing.JButton();
        Inventory14 = new javax.swing.JButton();
        Inventory8 = new javax.swing.JButton();
        Inventory13 = new javax.swing.JButton();
        Inventory18 = new javax.swing.JButton();
        Inventory19 = new javax.swing.JButton();
        Inventory17 = new javax.swing.JButton();
        Inventory16 = new javax.swing.JButton();
        Inventory15 = new javax.swing.JButton();
        Inventory9 = new javax.swing.JButton();
        Inventory4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InventoryLog = new javax.swing.JTextArea();
        weaponLabel = new javax.swing.JLabel();
        damageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Inventory3.setText(initText(3));
        Inventory3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory3ActionPerformed(evt);
            }
        });

        Inventory6.setText( initText(6));
        Inventory6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory6ActionPerformed(evt);
            }
        });

        Inventory10.setText( initText(10));
        Inventory10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory10ActionPerformed(evt);
            }
        });

        Inventory1.setText(initText(1));
        Inventory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory1ActionPerformed(evt);
            }
        });

        Inventory11.setText(initText(11));
        Inventory11.setToolTipText("");
        Inventory11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory11ActionPerformed(evt);
            }
        });

        Inventory5.setText( initText(5));
        Inventory5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory5ActionPerformed(evt);
            }
        });

        Inventory12.setText( initText(12));
        Inventory12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory12ActionPerformed(evt);
            }
        });

        Inventory0.setText( initText(0));
        Inventory0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory0ActionPerformed(evt);
            }
        });

        Inventory2.setText( initText(2));
        Inventory2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory2ActionPerformed(evt);
            }
        });

        Inventory7.setText( initText(7));
        Inventory7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory7ActionPerformed(evt);
            }
        });

        Inventory14.setText(initText(14));
        Inventory14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory14ActionPerformed(evt);
            }
        });

        Inventory8.setText(initText(8));
        Inventory8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory8ActionPerformed(evt);
            }
        });

        Inventory13.setText(initText(13));
        Inventory13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory13ActionPerformed(evt);
            }
        });

        Inventory18.setText(initText(18));
        Inventory18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory18ActionPerformed(evt);
            }
        });

        Inventory19.setText(initText(19));
        Inventory19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory19ActionPerformed(evt);
            }
        });

        Inventory17.setText(initText(17));
        Inventory17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory17ActionPerformed(evt);
            }
        });

        Inventory16.setText(initText(16));
        Inventory16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory16ActionPerformed(evt);
            }
        });

        Inventory15.setText(initText(15));
        Inventory15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory15ActionPerformed(evt);
            }
        });

        Inventory9.setText(initText(9));
        Inventory9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory9ActionPerformed(evt);
            }
        });

        Inventory4.setText(initText(4));
        Inventory4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inventory4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Inventory0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Inventory1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(Inventory3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Inventory4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(Inventory2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Inventory8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Inventory7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Inventory9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Inventory12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Inventory17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Inventory13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Inventory18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Inventory14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Inventory19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Inventory5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Inventory10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Inventory15, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Inventory6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Inventory11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Inventory16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(Inventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inventory0, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inventory5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inventory10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inventory15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inventory11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inventory16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inventory6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inventory7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inventory3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inventory4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventory19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InventoryLog.setColumns(20);
        InventoryLog.setRows(5);
        jScrollPane1.setViewportView(InventoryLog);

        weaponLabel.setText(model.getEquippedWeaponText());
        weaponLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        damageLabel.setBackground(new java.awt.Color(255, 255, 255));
        damageLabel.setText(model.getEquippedWeaponDAmage());
        damageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(weaponLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(damageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weaponLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(damageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inventory7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory7ActionPerformed
        ButtonStuff(7, Inventory7, evt);
    }//GEN-LAST:event_Inventory7ActionPerformed

    private void Inventory2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory2ActionPerformed
        ButtonStuff(2, Inventory2, evt);
    }//GEN-LAST:event_Inventory2ActionPerformed

    private void Inventory0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory0ActionPerformed
        ButtonStuff(0, Inventory0, evt);
    }//GEN-LAST:event_Inventory0ActionPerformed

    private void Inventory12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory12ActionPerformed
        ButtonStuff(12, Inventory12, evt);
    }//GEN-LAST:event_Inventory12ActionPerformed

    private void Inventory5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory5ActionPerformed
        ButtonStuff(5, Inventory5, evt);
    }//GEN-LAST:event_Inventory5ActionPerformed

    private void Inventory11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory11ActionPerformed
        ButtonStuff(11, Inventory11, evt);
    }//GEN-LAST:event_Inventory11ActionPerformed

    private void Inventory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory1ActionPerformed
        ButtonStuff(1, Inventory1, evt);
    }//GEN-LAST:event_Inventory1ActionPerformed

    private void Inventory10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory10ActionPerformed
        ButtonStuff(10, Inventory10, evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_Inventory10ActionPerformed

    private void Inventory6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory6ActionPerformed
        ButtonStuff(6, Inventory6, evt);
    }//GEN-LAST:event_Inventory6ActionPerformed

    //place 0
    private void Inventory3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory3ActionPerformed
        ButtonStuff(3, Inventory3, evt);
    }//GEN-LAST:event_Inventory3ActionPerformed

    private void Inventory14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory14ActionPerformed
        ButtonStuff(14, Inventory14, evt);
    }//GEN-LAST:event_Inventory14ActionPerformed

    private void Inventory8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory8ActionPerformed
        ButtonStuff(8, Inventory8, evt);
    }//GEN-LAST:event_Inventory8ActionPerformed

    private void Inventory13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory13ActionPerformed
        ButtonStuff(13, Inventory13, evt);
    }//GEN-LAST:event_Inventory13ActionPerformed

    private void Inventory18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory18ActionPerformed
        ButtonStuff(18, Inventory18, evt);
    }//GEN-LAST:event_Inventory18ActionPerformed

    private void Inventory19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory19ActionPerformed
        ButtonStuff(19, Inventory19, evt);
    }//GEN-LAST:event_Inventory19ActionPerformed

    private void Inventory17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory17ActionPerformed
        ButtonStuff(17, Inventory17, evt);
    }//GEN-LAST:event_Inventory17ActionPerformed

    private void Inventory16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory16ActionPerformed
        ButtonStuff(16, Inventory16, evt);
    }//GEN-LAST:event_Inventory16ActionPerformed

    private void Inventory15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory15ActionPerformed
        ButtonStuff(15, Inventory15, evt);
    }//GEN-LAST:event_Inventory15ActionPerformed

    private void Inventory9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory9ActionPerformed
        ButtonStuff(9, Inventory9, evt);
    }//GEN-LAST:event_Inventory9ActionPerformed

    private void Inventory4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inventory4ActionPerformed
        ButtonStuff(4, Inventory4, evt);
    }//GEN-LAST:event_Inventory4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InventoryScreen dialog = new InventoryScreen(new javax.swing.JFrame(), true, new InventoryScreenModel());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inventory0;
    private javax.swing.JButton Inventory1;
    private javax.swing.JButton Inventory10;
    private javax.swing.JButton Inventory11;
    private javax.swing.JButton Inventory12;
    private javax.swing.JButton Inventory13;
    private javax.swing.JButton Inventory14;
    private javax.swing.JButton Inventory15;
    private javax.swing.JButton Inventory16;
    private javax.swing.JButton Inventory17;
    private javax.swing.JButton Inventory18;
    private javax.swing.JButton Inventory19;
    private javax.swing.JButton Inventory2;
    private javax.swing.JButton Inventory3;
    private javax.swing.JButton Inventory4;
    private javax.swing.JButton Inventory5;
    private javax.swing.JButton Inventory6;
    private javax.swing.JButton Inventory7;
    private javax.swing.JButton Inventory8;
    private javax.swing.JButton Inventory9;
    private javax.swing.JTextArea InventoryLog;
    private javax.swing.JLabel damageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel weaponLabel;
    // End of variables declaration//GEN-END:variables

}
