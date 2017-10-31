/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.DefaultListModel;

/**
 *
 * @author student
 */
public class Window extends javax.swing.JFrame {
    DefaultListModel model = new DefaultListModel();
    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        people.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        removeMenu = new javax.swing.JMenuItem();
        removeAllMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenuItem();
        openFileMenu = new javax.swing.JMenuItem();
        saveFileMenu = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        people = new javax.swing.JList<>();
        nameTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectPerson = new javax.swing.JComboBox<>();

        removeMenu.setText("Smazat");
        removeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuActionPerformed(evt);
            }
        });
        popupMenu.add(removeMenu);

        removeAllMenu.setText("Smazat vše");
        removeAllMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllMenuActionPerformed(evt);
            }
        });
        popupMenu.add(removeAllMenu);

        editMenu.setText("Upravit");
        editMenu.setActionCommand("edit");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });
        popupMenu.add(editMenu);

        openFileMenu.setText("Otevrit ze souboru");
        openFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuActionPerformed(evt);
            }
        });
        popupMenu.add(openFileMenu);

        saveFileMenu.setText("Ulozit do souboru");
        saveFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuActionPerformed(evt);
            }
        });
        popupMenu.add(saveFileMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        people.setComponentPopupMenu(popupMenu);
        jScrollPane1.setViewportView(people);

        nameTextField.setToolTipText("Zadej jméno");

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Jméno osoby");

        selectPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clovek", "Sportovec", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(selectPerson.getSelectedItem() == "Sportovec"){
            Human clovek = new Sportsman(nameTextField.getText());
            model.addElement(clovek);
        }
        else{
            Human clovek = new Human(nameTextField.getText());
            model.addElement(clovek);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuActionPerformed
        int selectedIndex = people.getSelectedIndex();
        if (selectedIndex != -1){
            model.remove(selectedIndex);
        }
    }//GEN-LAST:event_removeMenuActionPerformed

    private void removeAllMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllMenuActionPerformed
        model.removeAllElements();
    }//GEN-LAST:event_removeAllMenuActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        if(people.getSelectedIndex() > -1){
            Human person = (Human)model.get(people.getSelectedIndex());
            PersonDialog dialog = new PersonDialog(this,true,person);
            if(dialog.showDialog().equalsIgnoreCase("OK")){
                model.setElementAt(dialog.getPerson(),people.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_editMenuActionPerformed

    private void openFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuActionPerformed
        try (BufferedReader br = new BufferedReader(new FileReader("soubor.txt")))
        {
                String s;
                int i = 0;
                while ((s = br.readLine()) != null)
                {
                        if(i>0)
                        {
                            String[] attr = s.split(";");
                            Human person = new Human(attr[1]);
                            person.setAge(Integer.parseInt(attr[2]));
                            person.setHeight(Float.parseFloat(attr[3]));
                            person.setWeight(Integer.parseInt(attr[4]));
                            if(attr[5] == "MAN")
                                person.setSex(Human.Sex.MAN);
                            else
                                person.setSex(Human.Sex.WOMAN);
                            model.addElement(person);
                        }
                        i++;
                }
        }
        catch (Exception e)
        {
            System.err.println("Chyba při četení ze souboru.");
        }
    }//GEN-LAST:event_openFileMenuActionPerformed

    private void saveFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuActionPerformed
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt")))
        {
                bw.write("class;name;age;height;weight;sex");
                bw.newLine();
                for(int i=0; i<model.getSize();i++)
                {
                    Human person = (Human)model.get(i);
                    String output = person.getClass().getSimpleName() + ";"
                            + person.getName() + ";"
                            + person.getAge() + ";"
                            + person.getHeight() + ";"
                            + person.getWeight() + ";"
                            + person.getSex();  
                    bw.write(output);
                    bw.newLine();
                }
                bw.flush();
        }catch (Exception e)
        {
                System.err.println("Do souboru se nepovedlo zapsat.");
        }
    }//GEN-LAST:event_saveFileMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem editMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JMenuItem openFileMenu;
    private javax.swing.JList<String> people;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeAllMenu;
    private javax.swing.JMenuItem removeMenu;
    private javax.swing.JMenuItem saveFileMenu;
    private javax.swing.JComboBox<String> selectPerson;
    // End of variables declaration//GEN-END:variables
}
