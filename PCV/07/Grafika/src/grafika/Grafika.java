/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ucitel
 */
public class Grafika {
    private JFrame window;
    private JButton drawButton;
    private JLabel headLabel;
    private Platno platno;
            
    public Grafika(String title, int width, int height) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        /* Vytvoření nápisu okna */
        headLabel = new JLabel(title);
        // Nastavení písma nadpisu
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Arial", style , 20);
        headLabel.setFont(font);
        // Nastavení barvy pozadí a písma
        headLabel.setBackground(Color.blue);
        headLabel.setOpaque(true);
        headLabel.setForeground(Color.white);
        // Nastavení zarovnání a odsazení
        headLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        headLabel.setHorizontalAlignment(JLabel.CENTER);        
        /* Vytvoření objektu plátna */
        platno = new Platno();
        platno.init();
        /* Vytvoření tlačítka */
        drawButton = new JButton("Náhodně");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int x = (int) Math.floor(Math.random()*platno.getWidth());
               int y = (int) Math.floor(Math.random()*platno.getHeight());
               platno.setPoint(x,y,true);
               platno.repaint();
            }
        });
        /* Uložení kontejneru okna do proměnné pane */
        Container pane = window.getContentPane();
        /* Vložení grafických objektů do jednotlivých
        oblastí okna */
        pane.add(headLabel, BorderLayout.PAGE_START);
        pane.add(drawButton, BorderLayout.PAGE_END);
        pane.add(platno, BorderLayout.CENTER);
        
        window.setVisible(true);
    }    
    
    /**
     * @param args the command line arguments
     */        
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Grafika("Grafika v Javě", 800, 600);
    }
    
}
