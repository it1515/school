/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponeditor;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author nesty
 */
public class WeaponDialog extends javax.swing.JDialog {
    private MeleeWeapon meleeweapon;
    private RangeWeapon rangeweapon;
    private String actionButton = "Storno";
    /**
     * Creates new form WeaponDialog
     */
    public WeaponDialog(java.awt.Frame parent, boolean modal, MeleeWeapon weapon) {
        super(parent, modal);
        initComponents();
        this.meleeweapon = weapon;
        name.setText(weapon.getName());
        dmg.setValue(weapon.getDmg());
        attackspeed.setValue(weapon.getAttackspeed());
        selectWeapon.removeAllItems();
        selectWeapon.setModel(new DefaultComboBoxModel(MeleeWeapon.Type.values()));
        selectWeapon.setSelectedItem(weapon.getType());
        range.setValue(weapon.getRange());
        durability.setValue(weapon.getDurability());
        selectRarity.removeAllItems();
        selectRarity.setModel(new DefaultComboBoxModel(Weapon.Rarity.values()));
        selectRarity.setSelectedItem(weapon.getRarity());
    }
    
    public WeaponDialog(java.awt.Frame parent, boolean modal, RangeWeapon weapon) {
        super(parent, modal);
        initComponents();
        this.rangeweapon = weapon;
        name.setText(weapon.getName());
        dmg.setValue(weapon.getDmg());
        attackspeed.setValue(weapon.getAttackspeed());
        selectWeapon.removeAllItems();
        selectWeapon.setModel(new DefaultComboBoxModel(RangeWeapon.Type.values()));
        selectWeapon.setSelectedItem(weapon.getType());
        range.setValue(weapon.getRange());
        durability.setValue(weapon.getDurability());
        selectRarity.removeAllItems();
        selectRarity.setModel(new DefaultComboBoxModel(Weapon.Rarity.values()));
        selectRarity.setSelectedItem(weapon.getRarity());
    }
    
    public String showDialog(String weapon) {
        weaponLabel.setText(weapon);
        this.setVisible(true);
        return actionButton;
    }
    
    public MeleeWeapon getMeleeWeapon(){
        this.meleeweapon.setName(name.getText());
        this.meleeweapon.setDmg((int)dmg.getValue());
        this.meleeweapon.setAttackspeed((int)attackspeed.getValue());
        this.meleeweapon.setType((MeleeWeapon.Type) selectWeapon.getSelectedItem());
        this.meleeweapon.setRange((int)range.getValue());
        this.meleeweapon.setDurability((int)durability.getValue());
        this.meleeweapon.setRarity((Weapon.Rarity) selectRarity.getSelectedItem());
        return this.meleeweapon;
    }
    
    public RangeWeapon getRangeWeapon(){
        this.rangeweapon.setName(name.getText());
        this.rangeweapon.setDmg((int)dmg.getValue());
        this.rangeweapon.setAttackspeed((int)attackspeed.getValue());
        this.rangeweapon.setType((RangeWeapon.Type) selectWeapon.getSelectedItem());
        this.rangeweapon.setRange((int)range.getValue());
        this.rangeweapon.setDurability((int)durability.getValue());
        this.rangeweapon.setRarity((Weapon.Rarity) selectRarity.getSelectedItem());
        return this.rangeweapon;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dmg = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        weaponLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectWeapon = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        range = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        attackspeed = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        durability = new javax.swing.JSlider();
        selectRarity = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Storno");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("nazev");

        jLabel2.setText("dmg");

        weaponLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        weaponLabel.setText("Melee Weapon");

        jLabel3.setText("speed");

        selectWeapon.setModel(new DefaultComboBoxModel(MeleeWeapon.Type.values()));
        selectWeapon.setSelectedItem(MeleeWeapon.Type.Sword);
        selectWeapon.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                selectWeaponComponentAdded(evt);
            }
        });
        selectWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWeaponActionPerformed(evt);
            }
        });

        jLabel4.setText("typ");

        range.setMajorTickSpacing(50);
        range.setMinorTickSpacing(10);
        range.setPaintLabels(true);
        range.setPaintTicks(true);
        range.setValue(0);

        jLabel5.setText("range");

        jLabel6.setText("durability");

        durability.setMajorTickSpacing(50);
        durability.setMinorTickSpacing(10);
        durability.setPaintLabels(true);
        durability.setPaintTicks(true);
        durability.setValue(0);

        selectRarity.setModel(new DefaultComboBoxModel(MeleeWeapon.Type.values()));
        selectRarity.setSelectedItem(MeleeWeapon.Type.Sword);
        selectRarity.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                selectRarityComponentAdded(evt);
            }
        });
        selectRarity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRarityActionPerformed(evt);
            }
        });

        jLabel7.setText("vzacnost");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(OKButton)
                        .addGap(28, 28, 28)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(weaponLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dmg, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(attackspeed, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(durability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(range, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectRarity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(weaponLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectRarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dmg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(attackspeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(range, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(durability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        actionButton = "OK";
        this.dispose();
    }//GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        actionButton = "Storno";
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void selectWeaponComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_selectWeaponComponentAdded

    }//GEN-LAST:event_selectWeaponComponentAdded

    private void selectWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectWeaponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectWeaponActionPerformed

    private void selectRarityComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_selectRarityComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_selectRarityComponentAdded

    private void selectRarityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRarityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectRarityActionPerformed

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
            java.util.logging.Logger.getLogger(WeaponDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeaponDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeaponDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeaponDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                WeaponDialog dialog = new WeaponDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton OKButton;
    private javax.swing.JSpinner attackspeed;
    private javax.swing.JSpinner dmg;
    private javax.swing.JSlider durability;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField name;
    private javax.swing.JSlider range;
    private javax.swing.JComboBox<String> selectRarity;
    private javax.swing.JComboBox<String> selectWeapon;
    private javax.swing.JLabel weaponLabel;
    // End of variables declaration//GEN-END:variables
}