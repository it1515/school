/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ml-notebook
 */
public class OknoSlovnik extends javax.swing.JFrame {

    /* Atribut udržující připojení k databázi */
    private Connection spojeni;
    /* Atribut určený pro model tabulky */
    private final DefaultTableModel model;

    /**
     * Konstruktor třídy OknoSlovnik
     */
    public OknoSlovnik() {
        /* Inicializace komponent okna */
        initComponents();
        /* Nastavení modelu komponenty JTable */
        tabulka.setModel(new javax.swing.table.DefaultTableModel(
                /* Dvourozměrné pole objektů */
                new Object[][]{
                    {null, null, null, null}
                },
                /* Označení záhlaví sloupců - pole typu String */
                new String[]{
                    "ID", "Čeština", "Angličtina", "Polština", "Obtížnost"
                }
        ) {
            /* Definování datových typů pro jednotlivé sloupce */
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            /* Metoda vrací datový typ určitého sloupce */
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            /* Vrací informaci, zda je možné buňku editovat */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        /* Do proměnné model je uložen výchozí model tabulky */
        model = (DefaultTableModel) tabulka.getModel();
        /* Do proměnné tm je uložen první sloupec tabulky */
        TableColumn tm = tabulka.getColumnModel().getColumn(0);
        /* Nastaví se maximální šířka sloupce */
        tm.setMaxWidth(50);
        /* Zakáže se možnost změny šířky */
        tm.setResizable(false);
        /* Nastaví se barevné vykreslování buněk */
        tm.setCellRenderer(new ColorColumnRenderer(Color.gray, Color.white));
        /* Pro tabulku se aktivuje možnost automatického řazení podle sloupců */
        tabulka.setAutoCreateRowSorter(true);
        /* Volání metody, která zajišťuje připojení k MySQL serveru prostřednictvím JDBC konektoru */
        this.dbConnection();
        /* Volání metody listData, které jsou jako parametr předána data získaná pomocí metody getAllRecords */
        this.listData(this.getAllRecords());
    }

    /* Metoda zajistí výpis dat v tabulce podle aktuální sady záznamů */
    private void listData(ResultSet data) {
        /* Cyklus provede odstranění všech řádků tabulky */
        for (int i = tabulka.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try {
            /* Cyklus přidává datové řady do tabulky; dokud data.next() nevrátí false (protože už neexistuje žádný další záznam)  */
            while (data.next()) {
                int id = data.getInt(1);
                String cesky = data.getString("cs");
                String anglicky = data.getString("en");
                String polsky = data.getString("pl");
                int obtiznost = data.getInt("obtiznost");
                /* Přidávaný řádek je objektem, který tvoří hodnoty pro jednotlivé sloupce tabulky */
                model.addRow(new Object[]{id, cesky, anglicky, polsky, obtiznost});
            }
            /* Nastavení informace o počtu záznamů do stavového řádku */
            pocetZaznamu.setText("Počet záznamů: " + getRowsCount(data));
            /* Obsahuje-li tabulka aspoň jeden řádek s daty, je možné povolit akce (ikony) update a delete */
            if (tabulka.getRowCount() > 0) {
                tabulka.setRowSelectionInterval(0, 0);
                update.setEnabled(true);
                delete.setEnabled(true);
            } else {
                update.setEnabled(false);
                delete.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Metoda zajišťuje připojení k serveru MySQL prostřednictvím JDBC */
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

    /* Metoda vrací sadu všech záznamů z tabulky slovnicek */
    private ResultSet getAllRecords() {
        ResultSet vysledky = null;
        try {
            /* Připravený SQL dotaz */
            PreparedStatement dotaz = this.spojeni.prepareStatement("SELECT * FROM slovnicek");
            /* Provedení dotazu a předání výsledků */
            vysledky = dotaz.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return vysledky;
    }

    /* Metoda vrací sadu všech záznamů podle zvoleného jazyka, které obsahují určitý řetězec  */
    private ResultSet search(String word, String jazyk) {
        ResultSet vysledky = null;
        try {
            /* Parametrizovaný dotaz - otazník představuje vždy jeden parametr */
            PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM slovnicek WHERE " + jazyk + " LIKE ?");
            /* Do prvního parametru dotazu bude dosazen hledaný řetězec, symboly % zastupují libovolné znaky */
            dotaz.setString(1, "%" + word + "%");
            vysledky = dotaz.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return vysledky;
    }

    /* Metoda vrací počet záznamů v sadě, která byla vznikla jako výsledek výběrového dotazu */
    private int getRowsCount(ResultSet rs) {
        try {
            /* přesun ukazatele na poslední záznam v sadě */
            rs.last();
            /* vrací číslo posledního řádku/záznamu dané sady */
            int pocet = rs.getRow();
            /* přesun ukazatele před první záznam */
            rs.beforeFirst();
            return pocet;
        } catch (SQLException ex) {
            return 0;
        }
    }

    /* Metoda zajistí vložení nových slovíček do databáze */
    private int insertRecord(String enWord, String csWord, String plWord, int obtiznost) {
        int numRows = 0;
        try {
            /* Parametrizovaný dotaz obsahuje 2 parametry */
            PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO slovnicek (cs, en, pl, obtiznost) VALUES (?, ?, ?, ?)");
            /* Dosazení řetězce za první a druhý parametr */
            dotaz.setString(1, csWord);
            dotaz.setString(2, enWord);
            dotaz.setString(3, plWord);
            dotaz.setInt(4, obtiznost);
            /* Aktualizace databáze, návratová hodnota představuje celkový počet záznamů */
            numRows = dotaz.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return numRows;
    }

    /* Metoda zajistí aktualizaci vybraného záznamu (podle id) */
    private int updateRecord(int id, String enWord, String csWord, String plWord, int obtiznost) {
        int numRows = 0;
        try {
            PreparedStatement dotaz = spojeni.prepareStatement("UPDATE slovnicek SET cs=?, en=?, pl=?, obtiznost=? WHERE id=?");
            dotaz.setString(1, csWord);
            dotaz.setString(2, enWord);
            dotaz.setString(3, plWord);
            dotaz.setInt(4, obtiznost);
            dotaz.setInt(5, id);
            numRows = dotaz.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return numRows;
    }

    /* Metoda odstraní zvolený záznam */
    private int deleteRecord(int id) {
        int numRows = 0;
        try {
            PreparedStatement dotaz = spojeni.prepareStatement("DELETE FROM slovnicek WHERE id=?");
            dotaz.setInt(1, id);
            numRows = dotaz.executeUpdate();
            listData(this.getAllRecords());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return numRows;
    }

    /* Metoda slouží k zápisu dat do textové souboru (využívá se pro export do XML, JSON a CSV) */
    public Boolean ulozDoSouboru(File soubor, String charset, String data) {
        try {
            /* Otevření proudu pro zápis do souboru */
            OutputStream outputStream = new FileOutputStream(soubor);
            /* Provedení zápisu dat do souboru v dané znakové sadě */
            try (Writer writer = new OutputStreamWriter(outputStream, charset)) {
                writer.write(data);
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabulka = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        search = new javax.swing.JButton();
        jazyk = new javax.swing.JComboBox();
        findText = new javax.swing.JTextField();
        showAll = new javax.swing.JButton();
        testBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pocetZaznamu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuExport = new javax.swing.JMenu();
        menuCSV = new javax.swing.JMenuItem();
        menuJSON = new javax.swing.JMenuItem();
        menuXML = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuData = new javax.swing.JMenu();
        menuInsert = new javax.swing.JMenuItem();
        menuUpdate = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Česko-anglický slovníček");

        tabulka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "cs", "en"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabulka.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabulkaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabulka);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 30));

        insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/insert.png"))); // NOI18N
        insert.setMnemonic('N');
        insert.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/insert-disabled.png"))); // NOI18N
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jToolBar1.add(insert);

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/update.png"))); // NOI18N
        update.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/update-disabled.png"))); // NOI18N
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jToolBar1.add(update);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/delete.png"))); // NOI18N
        delete.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/delete-disabled.png"))); // NOI18N
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jToolBar1.add(delete);
        jToolBar1.add(jSeparator1);

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/search.png"))); // NOI18N
        search.setText("Hledej");
        search.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionary/search-disabled.png"))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jToolBar1.add(search);

        jazyk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cs", "en", "pl", "obtiznost" }));
        jazyk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jazykActionPerformed(evt);
            }
        });
        jToolBar1.add(jazyk);

        findText.setMinimumSize(new java.awt.Dimension(150, 20));
        findText.setName(""); // NOI18N
        findText.setPreferredSize(new java.awt.Dimension(150, 20));
        jToolBar1.add(findText);

        showAll.setText("Zobrazit vše");
        showAll.setFocusable(false);
        showAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllActionPerformed(evt);
            }
        });
        jToolBar1.add(showAll);

        testBtn.setText("Test");
        testBtn.setFocusable(false);
        testBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        testBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testBtnActionPerformed(evt);
            }
        });
        jToolBar1.add(testBtn);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pocetZaznamu.setText("Počet záznamů:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pocetZaznamu)
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pocetZaznamu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        menuFile.setMnemonic('s');
        menuFile.setText("Soubor");
        menuFile.setToolTipText("");
        menuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileActionPerformed(evt);
            }
        });

        menuExport.setText("Export");

        menuCSV.setText("CSV...");
        menuCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCSVActionPerformed(evt);
            }
        });
        menuExport.add(menuCSV);

        menuJSON.setText("JSON...");
        menuJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJSONActionPerformed(evt);
            }
        });
        menuExport.add(menuJSON);

        menuXML.setText("XML...");
        menuXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuXMLActionPerformed(evt);
            }
        });
        menuExport.add(menuXML);

        menuFile.add(menuExport);
        menuFile.add(jSeparator2);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setMnemonic('k');
        menuExit.setText("Konec");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        jMenuBar1.add(menuFile);

        menuData.setMnemonic('d');
        menuData.setText("Data");

        menuInsert.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuInsert.setMnemonic('v');
        menuInsert.setText("Vložit záznam");
        menuInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertActionPerformed(evt);
            }
        });
        menuData.add(menuInsert);

        menuUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuUpdate.setMnemonic('z');
        menuUpdate.setText("Změnit záznam");
        menuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdateActionPerformed(evt);
            }
        });
        menuData.add(menuUpdate);

        menuDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuDelete.setMnemonic('s');
        menuDelete.setText("Smazat záznam");
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        menuData.add(menuDelete);

        jMenuBar1.add(menuData);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Ohlasová metoda na akci Search */
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        /* Do proměnné hledany se uloží text zadaný do vstupního pole findText */
        String hledany = findText.getText();
        /* Zavolání metody search */
        ResultSet data = this.search(hledany, jazyk.getSelectedItem().toString());
        /* V případě, že byl nalezen aspoň 1 záznam */
        if (getRowsCount(data) > 0) {
            listData(data);
        } else {
            JOptionPane.showMessageDialog(this, "Žádný záznam nenalezen", "Výsledek hledání", JOptionPane.QUESTION_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    /* Ohlasová metoda na akci insert - vložení nového slovíčka */
    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String[] slova = {"", "", "",""};
        /* Otevře dialogové okno slovaDialog */
        slovaDialog slovaDialog = new slovaDialog(this, true, slova);
        /* Nastaví titulek okna */
        slovaDialog.setTitle("Nové slovo");

        /* Zobrazení dialogového okna metodou showDialog() */
        if (slovaDialog.showDialog().equalsIgnoreCase("OK")) {
            /* Vložení nového záznamu do databáze */
            insertRecord(slovaDialog.getAnglicky(), slovaDialog.getCesky(), slovaDialog.getPolsky(),slovaDialog.getObtiznost());
        }
        /* Aktualizovaný výpis záznamů */
        listData(this.getAllRecords());
    }//GEN-LAST:event_insertActionPerformed

    /* Ohlasová metoda na akci Update */
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        /* zjištění id podle označeného řádku tabulky (z prvního sloupce - index 0) */
        int id = (int) tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 0);
        /* Zjistí slovíčka ve vyznačeném řádku tabulky a uloží je do pole */
        String[] slova = {tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 1).toString(), tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 2).toString(), tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 3).toString(), tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 4).toString()};
        /* Otevře dialogové okno a  prostřednictvím konstruktoru předá zvolená slova */
        slovaDialog slovaDialog = new slovaDialog(this, true, slova);
        /* Změní titulek dialogového okna */
        slovaDialog.setTitle("Změnit slovo");
        /* Zobrazení dialogového okna metodou showDialog() */
        if (slovaDialog.showDialog().equalsIgnoreCase("OK")) {
            updateRecord(id, slovaDialog.getAnglicky(), slovaDialog.getCesky(), slovaDialog.getPolsky(),slovaDialog.getObtiznost());
        }
        listData(this.getAllRecords());
    }//GEN-LAST:event_updateActionPerformed

    /* Ohlasová metoda na akci Delete */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int id = (int) tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 0);
        deleteRecord(id);
        listData(this.getAllRecords());
    }//GEN-LAST:event_deleteActionPerformed

    private void tabulkaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabulkaFocusGained
    }//GEN-LAST:event_tabulkaFocusGained

    /* Zajistí zobrazení všech záznamů */
    private void showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllActionPerformed
        listData(this.getAllRecords());
    }//GEN-LAST:event_showAllActionPerformed

    private void menuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileActionPerformed

    }//GEN-LAST:event_menuFileActionPerformed

    /* Jednotlivé akce menu */
    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed
    
    private void menuInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertActionPerformed
        this.insertActionPerformed(null);
    }//GEN-LAST:event_menuInsertActionPerformed

    private void menuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdateActionPerformed
        this.updateActionPerformed(null);
    }//GEN-LAST:event_menuUpdateActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed
        this.deleteActionPerformed(null);
    }//GEN-LAST:event_menuDeleteActionPerformed

    /* Export dat do CSV souboru */
    private void menuCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCSVActionPerformed
        try {
            /* Vytvoření a zobrazení dialogového okna pro uložení souboru */
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.SAVE_DIALOG);
            fc.setDialogTitle("Uložení souboru CSV");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("CSV soubor", "csv");
            fc.setFileFilter(myFilter);
            /* Nastavení záhlaví CSV souboru */
            String data = "id;cs;en\n";
            /* Výpis slovíček na samostatné řádky */
            for (int i = 0; i < tabulka.getRowCount(); i++) {
                data += tabulka.getModel().getValueAt(i, 0).toString() + ";" + tabulka.getModel().getValueAt(i, 1).toString() + ";" + tabulka.getModel().getValueAt(i, 2).toString();
                data += (i == tabulka.getRowCount() - 1) ? "" : "\n";
            }
            /* Uložení do souboru s kódováním Window-1250 */
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.ulozDoSouboru(fc.getSelectedFile(), "Windows-1250", data);
            }
        } // Zachycení obecné výjimky
        catch (HeadlessException e) {
            // Zobrazení dialogového okna s upozorněním na chybu
            JOptionPane.showMessageDialog(this, "Nastala chyba při ukládání souboru!", "Chyba!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_menuCSVActionPerformed

    /* Export do JSON */ 
    private void menuJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJSONActionPerformed
        try {
            /* Vytvoření a zobrazení dialogového okna pro uložení souboru */
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.SAVE_DIALOG);
            fc.setDialogTitle("Uložení souboru JSON");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("JSON soubor", "json");
            fc.setFileFilter(myFilter);
            String data = "{\"slovnik\": [\n";
            for (int i = 0; i < tabulka.getRowCount(); i++) {
                data += "\t{\"id\":\"" + tabulka.getModel().getValueAt(i, 0).toString() + "\",";
                data += "\"cs\":\"" + tabulka.getModel().getValueAt(i, 1).toString() + "\",";
                data += "\"en\":\"" + tabulka.getModel().getValueAt(i, 2).toString() + "\"}";
                data += (i == tabulka.getRowCount() - 1) ? "\n" : ",\n";
            }
            data += "]}";
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.ulozDoSouboru(fc.getSelectedFile(), "UTF-8", data);
            }
        } // Zachycení obecné výjimky
        catch (HeadlessException e) {
            // Zobrazení dialogového okna s upozorněním na chybu
            JOptionPane.showMessageDialog(this, "Nastala chyba při ukládání souboru!", "Chyba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuJSONActionPerformed

    /* Export do XML */
    private void menuXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuXMLActionPerformed
        try {
            /* Vytvoření a zobrazení dialogového okna pro uložení souboru */
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.SAVE_DIALOG);
            fc.setDialogTitle("Uložení souboru XML");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("XML soubor", "xml");
            fc.setFileFilter(myFilter);
            String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<slovnik>\n";
            for (int i = 0; i < tabulka.getRowCount(); i++) {
                data += "\t<slovo id=\"" + tabulka.getModel().getValueAt(i, 0).toString() + "\" >\n";
                data += "\t\t<cs>" + tabulka.getModel().getValueAt(i, 1).toString() + "</cs>\n";
                data += "\t\t<en>" + tabulka.getModel().getValueAt(i, 2).toString() + "</en>\n";
                data += "\t</slovo>\n";
            }
            data += "</slovnik>";
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.ulozDoSouboru(fc.getSelectedFile(), "UTF-8", data);
            }
        } // Zachycení obecné výjimky
        catch (HeadlessException e) {
            // Zobrazení dialogového okna s upozorněním na chybu
            JOptionPane.showMessageDialog(this, "Nastala chyba při ukládání souboru!", "Chyba!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuXMLActionPerformed

    private void jazykActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jazykActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jazykActionPerformed

    private void testBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testBtnActionPerformed

        /* zjištění id podle označeného řádku tabulky (z prvního sloupce - index 0) */
        int rnd = 12;
        int id = (int) tabulka.getModel().getValueAt(tabulka.getSelectedRow(), 0);
        int numberRow = (int) tabulka.getModel().getRowCount();
        /* Zjistí slovíčka ve vyznačeném řádku tabulky a uloží je do pole */
        String[][] slova = new String[numberRow][5];
        String[][] invertSlova = new String[5][numberRow];
        
        //slova[0] = tabulka.getModel().getValueAt(0, 1).toString();
        for(int i=0;i<numberRow;i++){
            slova[i][0] = tabulka.getModel().getValueAt(i, 0).toString();
            slova[i][1] = tabulka.getModel().getValueAt(i, 1).toString();
            slova[i][2] = tabulka.getModel().getValueAt(i, 2).toString();
            slova[i][3] = tabulka.getModel().getValueAt(i, 3).toString();
            slova[i][4] = tabulka.getModel().getValueAt(i, 4).toString();
            invertSlova[0][i] = tabulka.getModel().getValueAt(i, 0).toString();
            invertSlova[1][i] = tabulka.getModel().getValueAt(i, 1).toString();
            invertSlova[2][i] = tabulka.getModel().getValueAt(i, 2).toString();
            invertSlova[3][i] = tabulka.getModel().getValueAt(i, 3).toString();
            invertSlova[4][i] = tabulka.getModel().getValueAt(i, 4).toString();
//            slova = {tabulka.getModel().getValueAt(i, 1).toString(),tabulka.getModel().getValueAt(i, 2).toString(),tabulka.getModel().getValueAt(i, 3).toString(),tabulka.getModel().getValueAt(i, 4).toString()};
        }
        
        /* Otevře dialogové okno a  prostřednictvím konstruktoru předá zvolená slova */
        testDialog testDialog = new testDialog(this, true, slova, invertSlova, numberRow);
        testDialog.setTitle("Test");
        
    }//GEN-LAST:event_testBtnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OknoSlovnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OknoSlovnik().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField findText;
    private javax.swing.JButton insert;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox jazyk;
    private javax.swing.JMenuItem menuCSV;
    private javax.swing.JMenu menuData;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuExport;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuInsert;
    private javax.swing.JMenuItem menuJSON;
    private javax.swing.JMenuItem menuUpdate;
    private javax.swing.JMenuItem menuXML;
    private javax.swing.JLabel pocetZaznamu;
    private javax.swing.JButton search;
    private javax.swing.JButton showAll;
    private javax.swing.JTable tabulka;
    private javax.swing.JButton testBtn;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
