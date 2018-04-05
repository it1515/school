/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author student
 */
public class testDialog extends javax.swing.JDialog {
    private String actionButton = "Storno";
    private int minpocetslov = 1, maxpocetslov = 10;
    private int numberRow2;
    private int pocetSpravne;
    private int ijazyky = 1;
    private int poradi = 0;
    private int [] randNums;
    private String[][] slova2;
    private String name;
    private Connection spojeni;
    /**
     * Creates new form testDialog
     * @param parent
     * @param modal
     * @param slova
     * @param invertSlova
     * @param numberRow
     */
    public testDialog(java.awt.Frame parent, boolean modal, String[][] slova, String[][] invertSlova,  int numberRow, Connection spojeni2) {
        super(parent, modal);
        initComponents();
        this.setTitle("Test");        
        slova2 = slova;
        spojeni = spojeni2;
        numberRow2 = numberRow;
        obtiznost.setValue(1);
        pocet.setValue(5);
        bar.setMaximum(5);
        bar2.setMaximum(5);
        listSlov.setListData(makeArray(numberRow2,slova2,(int)obtiznost.getValue(),ijazyky));
        this.setVisible(true);
    }
    
    private String[] makeArray(int numberRow, String[][] slova,int level,int jazyk){
        String[] arrayByObtiznost = new String[numberRow];
        int num = 0;
        for(int i=0; i<numberRow;i++){
            int islovo = Integer.parseInt(slova[i][4]);
            if(islovo == level){
                arrayByObtiznost[num] = slova[i][jazyk];
                num++;
            }
        }
        String[] arrayByObtiznostX = new String[num];
        for(int i = 0;i<num;i++){
            arrayByObtiznostX[i] = arrayByObtiznost[i];
        }
        return arrayByObtiznostX;
    }
    
    private int[] makeRandNums(String [] array,int j){
        int[] iarray = new int[j];
        int cislo;
        for(int i = 0;i<j-1;i++){
            do{
            Random ran = new Random();
            cislo = ran.nextInt(array.length);
            }while(checkArray(cislo,iarray,j));
            iarray[i] = cislo;
        }
        return iarray;
    }
    
    private boolean checkArray(int cislo,int[] iarray,int j){
        for(int i = 0;i<j-1;i++){
            if(cislo == iarray[i]){
                return true;
            }
        }
        return false;
    }
    
    private void dbConnection() {
        try {
            /* Připojení k MySQL zajišťuje statická metody getConnection třídy DriveManager
               Parametry metody getConnection jsou adresa MySQL serveru (včetně určení databáze a kódování) + přístupové údaje (uživatel, heslo)
               Po přetypování (Connection) je spojení uloženo do atributu spojeni
             */
            this.spojeni = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/slovnik?useUnicode=true&characterEncoding=utf-8", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Nedošlo k připojení databáze", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int insertRecord(String name, int pocet, int pocetSpravne, int obtiznost) {
        int numRows = 0;
        try {
            /* Parametrizovaný dotaz obsahuje 2 parametry */
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO testy (jmeno, pocet_slov, pocet_spravne, obtiznost) VALUES (?, ?, ?, ?)");
            /* Dosazení řetězce za první a druhý parametr */
            dotaz.setString(1, name);
            dotaz.setInt(2, pocet);
            dotaz.setInt(3, pocetSpravne);
            dotaz.setInt(4, obtiznost);
            /* Aktualizace databáze, návratová hodnota představuje celkový počet záznamů */
            numRows = dotaz.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return numRows;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jazyky = new javax.swing.ButtonGroup();
        csText = new javax.swing.JTextField();
        enText = new javax.swing.JTextField();
        plText = new javax.swing.JTextField();
        storno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSlov = new javax.swing.JList<>();
        bar = new javax.swing.JProgressBar();
        start = new javax.swing.JButton();
        obtiznost = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pocet = new javax.swing.JSpinner();
        next = new javax.swing.JButton();
        csRadioBtn = new javax.swing.JRadioButton();
        enRadioBtn = new javax.swing.JRadioButton();
        plRadioBtn = new javax.swing.JRadioButton();
        bar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        storno.setText("Storno");
        storno.setToolTipText("");
        storno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stornoActionPerformed(evt);
            }
        });

        listSlov.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listSlov);

        bar.setStringPainted(true);

        start.setText("Test");
        start.setToolTipText("");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        obtiznost.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                obtiznostStateChanged(evt);
            }
        });

        jLabel4.setText("obtížnost");

        jLabel5.setText("počet slov");

        pocet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pocetStateChanged(evt);
            }
        });

        next.setText("Další");
        next.setToolTipText("");
        next.setEnabled(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jazyky.add(csRadioBtn);
        csRadioBtn.setSelected(true);
        csRadioBtn.setText("čeština");
        csRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csRadioBtnActionPerformed(evt);
            }
        });

        jazyky.add(enRadioBtn);
        enRadioBtn.setText("angličtina");
        enRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enRadioBtnActionPerformed(evt);
            }
        });

        jazyky.add(plRadioBtn);
        plRadioBtn.setText("polština");
        plRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plRadioBtnActionPerformed(evt);
            }
        });

        bar2.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(start)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(obtiznost, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pocet, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(csRadioBtn)
                                            .addComponent(enRadioBtn)
                                            .addComponent(plRadioBtn)
                                            .addComponent(next))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(csText, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                            .addComponent(enText)
                                            .addComponent(plText))
                                        .addContainerGap())))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(storno)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bar2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(csRadioBtn)
                            .addComponent(csText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enRadioBtn)
                            .addComponent(enText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plRadioBtn)
                            .addComponent(plText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(next))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pocet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(obtiznost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start)
                    .addComponent(storno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stornoActionPerformed
        actionButton = "Storno";
        this.dispose();
    }//GEN-LAST:event_stornoActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        String [] aCzech = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),1);
        String [] aEnglish = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),2);
        String [] aPolish = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),3);
        pocetSpravne = 0;
        obtiznost.setEnabled(false);
        pocet.setEnabled(false);
        listSlov.setEnabled(false);
        next.setEnabled(true);
        start.setEnabled(false);
        csRadioBtn.setEnabled(false);
        enRadioBtn.setEnabled(false);
        plRadioBtn.setEnabled(false);
        randNums = makeRandNums(aCzech,(int)pocet.getValue());
        poradi = 0;
        bar.setValue(0);
        bar2.setValue(0);
        if(ijazyky == 1){
            csText.setEnabled(false);
            enText.setText(null);
            plText.setText(null);
            csText.setText(aCzech[randNums[poradi]]);
        }
        if(ijazyky == 2){
            enText.setEnabled(false);
            csText.setText(null);
            plText.setText(null);
            enText.setText(aEnglish[randNums[poradi]]);
        }
        if(ijazyky == 3){
            plText.setEnabled(false);
            enText.setText(null);
            csText.setText(null);
            plText.setText(aPolish[randNums[poradi]]);
        }        
    }//GEN-LAST:event_startActionPerformed

    private void obtiznostStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_obtiznostStateChanged
        if((int)obtiznost.getValue()>5)
            obtiznost.setValue(5);
        if((int)obtiznost.getValue()<1)
            obtiznost.setValue(1);
        listSlov.setListData(makeArray(numberRow2,slova2,(int)obtiznost.getValue(),ijazyky));
    }//GEN-LAST:event_obtiznostStateChanged

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        String [] aCzech = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),1);
        String [] aEnglish = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),2);
        String [] aPolish = makeArray(numberRow2,slova2,(int)obtiznost.getValue(),3);
        if(poradi < randNums.length){
            if(ijazyky == 1){
                if(enText.getText().equals(aEnglish[randNums[poradi]]) && plText.getText().equals(aPolish[randNums[poradi]])){
                    pocetSpravne++;     
                    bar.setValue(bar.getValue()+1);
                }
            }
            if(ijazyky == 2){               
                if(csText.getText().equals(aCzech[randNums[poradi]]) && plText.getText().equals(aPolish[randNums[poradi]])){
                    pocetSpravne++;     
                    bar.setValue(bar.getValue()+1);
                }
            }
            if(ijazyky == 3){              
                if(csText.getText().equals(aCzech[randNums[poradi]]) && enText.getText().equals(aEnglish[randNums[poradi]])){
                    pocetSpravne++;     
                    bar.setValue(bar.getValue()+1);
                }
            }
            if(poradi < randNums.length-1){
                poradi++;
                bar2.setValue(bar2.getValue()+1);
                if(ijazyky == 1){  
                    enText.setText("");
                    plText.setText("");
                    csText.setText(aCzech[randNums[poradi]]);
                }
                if(ijazyky == 2){  
                    csText.setText("");
                    plText.setText(""); 
                    enText.setText(aEnglish[randNums[poradi]]);
                }
                if(ijazyky == 3){
                    csText.setText("");
                    enText.setText("");
                    plText.setText(aPolish[randNums[poradi]]);
                }
            }
            else{
                bar2.setValue(bar2.getValue()+1);
                obtiznost.setEnabled(true);
                pocet.setEnabled(true);
                listSlov.setEnabled(true);
                next.setEnabled(false);
                start.setEnabled(true);
                csText.setEnabled(true);
                enText.setEnabled(true);
                plText.setEnabled(true);
                csText.setText(null);
                enText.setText(null);
                plText.setText(null);
                csRadioBtn.setEnabled(true);
                enRadioBtn.setEnabled(true);
                plRadioBtn.setEnabled(true);
                if((name = (JOptionPane.showInputDialog(this, "Jméno:")))!= null){
                    insertRecord(name,(int)pocet.getValue(),(int)bar.getValue(),(int)obtiznost.getValue());
                    JOptionPane.showMessageDialog(this, "Výsledek byl uložen do databáze", "Výborně!", JOptionPane.INFORMATION_MESSAGE);
                };
            }
        }
        
    }//GEN-LAST:event_nextActionPerformed

    private void pocetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pocetStateChanged
        bar.setMaximum((int)pocet.getValue());
        bar2.setMaximum((int)pocet.getValue());
        if((int)pocet.getValue()>maxpocetslov)
            pocet.setValue(maxpocetslov);
        if((int)pocet.getValue()<minpocetslov)
            pocet.setValue(minpocetslov);
    }//GEN-LAST:event_pocetStateChanged

    private void enRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enRadioBtnActionPerformed
        ijazyky = 2;
        listSlov.setListData(makeArray(numberRow2,slova2,(int)obtiznost.getValue(),ijazyky));
    }//GEN-LAST:event_enRadioBtnActionPerformed

    private void csRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csRadioBtnActionPerformed
        ijazyky = 1;
        listSlov.setListData(makeArray(numberRow2,slova2,(int)obtiznost.getValue(),ijazyky));       
    }//GEN-LAST:event_csRadioBtnActionPerformed

    private void plRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plRadioBtnActionPerformed
        ijazyky = 3;
        listSlov.setListData(makeArray(numberRow2,slova2,(int)obtiznost.getValue(),ijazyky));
    }//GEN-LAST:event_plRadioBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JProgressBar bar2;
    private javax.swing.JRadioButton csRadioBtn;
    private javax.swing.JTextField csText;
    private javax.swing.JRadioButton enRadioBtn;
    private javax.swing.JTextField enText;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jazyky;
    private javax.swing.JList<String> listSlov;
    private javax.swing.JButton next;
    private javax.swing.JSpinner obtiznost;
    private javax.swing.JRadioButton plRadioBtn;
    private javax.swing.JTextField plText;
    private javax.swing.JSpinner pocet;
    private javax.swing.JButton start;
    private javax.swing.JButton storno;
    // End of variables declaration//GEN-END:variables
}
