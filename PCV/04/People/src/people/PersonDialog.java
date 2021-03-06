/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import people.Human.Sex;

/**
 *
 * @author student
 */
public class PersonDialog extends javax.swing.JDialog {
private Human person;
private String actionButton = "Storno";
    /**
     * Creates new form PersonDialog
     */
    public PersonDialog(java.awt.Frame parent, boolean modal, Human person) {
        super(parent, modal);
        initComponents();
        this.person = person;
        name.setText(person.getName());
        age.setValue(person.getAge());
        weight.setValue(person.getWeight());
        height.setValue((int)(person.getHeight()*100));
        if(person.getSex() == Sex.MAN){
            manButton.setSelected(true);
        }
        else{
            womanButton.setSelected(true);
        }
    }
    
    public Human getPerson(){
        this.person.setName(name.getText());
        this.person.setAge((int)age.getValue());
        this.person.setWeight((int)weight.getValue());
        this.person.setHeight((float)height.getValue()/100);
        return this.person;
    }
    
    public String showDialog(){
        this.setVisible(true);
        return actionButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sexButtonGroup = new javax.swing.ButtonGroup();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        age = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        weight = new javax.swing.JSlider();
        weightText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        height = new javax.swing.JSlider();
        heightText = new javax.swing.JLabel();
        manButton = new javax.swing.JRadioButton();
        womanButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel1.setText("Jméno");

        OkButton.setText("OK");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("STORNO");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Věk");

        age.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ageStateChanged(evt);
            }
        });

        jLabel3.setText("Váha");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, weight, org.jdesktop.beansbinding.ELProperty.create("100"), weight, org.jdesktop.beansbinding.BeanProperty.create("maximum"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, weight, org.jdesktop.beansbinding.ELProperty.create("0"), weight, org.jdesktop.beansbinding.BeanProperty.create("minimum"));
        bindingGroup.addBinding(binding);

        weight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                weightStateChanged(evt);
            }
        });

        weightText.setText("0");
        weightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightTextActionPerformed(evt);
            }
        });
        weightText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weightTextKeyReleased(evt);
            }
        });

        jLabel4.setText("Výška");

        height.setMaximum(220);
        height.setMinimum(50);
        height.setToolTipText("");
        height.setValue(180);
        height.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                heightStateChanged(evt);
            }
        });

        heightText.setText("180");

        sexButtonGroup.add(manButton);
        manButton.setSelected(true);
        manButton.setText("muž");

        sexButtonGroup.add(womanButton);
        womanButton.setText("žena");
        womanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                womanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(heightText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(manButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(womanButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(OkButton)
                                        .addGap(76, 76, 76)
                                        .addComponent(CancelButton)))
                                .addGap(24, 24, 24)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(age))
                            .addGap(18, 18, 18)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(heightText))
                    .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manButton)
                    .addComponent(womanButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton)
                    .addComponent(CancelButton))
                .addGap(73, 73, 73))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        actionButton = "OK";
        this.dispose();
    }//GEN-LAST:event_OkButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        actionButton = "Storno";
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ageStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ageStateChanged

    private void weightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightTextActionPerformed

    }//GEN-LAST:event_weightTextActionPerformed

    private void weightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_weightStateChanged
        weightText.setText(String.valueOf(weight.getValue()));
    }//GEN-LAST:event_weightStateChanged

    private void weightTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightTextKeyReleased
        String typed = weightText.getText();
                weight.setValue(0);
                if(!typed.matches("\\d+") && !typed.matches("-\\d+") || typed.length() > 3) {
                    return;
                }
                weight.setValue(Integer.parseInt(typed));
    }//GEN-LAST:event_weightTextKeyReleased

    private void heightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_heightStateChanged
        heightText.setText(String.valueOf(height.getValue()));
    }//GEN-LAST:event_heightStateChanged

    private void womanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_womanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_womanButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton OkButton;
    private javax.swing.JSpinner age;
    private javax.swing.JSlider height;
    private javax.swing.JLabel heightText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton manButton;
    private javax.swing.JTextField name;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JSlider weight;
    private javax.swing.JTextField weightText;
    private javax.swing.JRadioButton womanButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
