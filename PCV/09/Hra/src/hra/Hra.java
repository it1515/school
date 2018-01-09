/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author student
 */
public class Hra {

    private JFrame window;
    private JButton drawButton;
    private JButton restartButton;
    private JLabel headLabel;
    
    public Hra(String title,int width,int height){
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width,height);
        /*Vytvoreni napisu okna*/
        headLabel = new JLabel(title);
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Arial",style,25);
        headLabel.setFont(font);
        headLabel.setBackground(Color.yellow);
        headLabel.setOpaque(true);
        headLabel.setForeground(Color.blue);
        headLabel.setBorder(new EmptyBorder(10,0,10,0));
        headLabel.setHorizontalAlignment(JLabel.CENTER);
        /*Vytvoreni tlačítka*/
        Platno platno = new Platno();
        platno.init();
        restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Restart");
            }
            
        });
        
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB), new Point(8,8), TOOL_TIP_TEXT_KEY);
        
        Container pane = window.getContentPane();
        //pane.add(headLabel,BorderLayout.PAGE_START);
        //pane.add(restartButton,BorderLayout.PAGE_END);
        pane.add(platno,BorderLayout.CENTER);
        pane.setCursor(cursor);
        window.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        new Hra("Hra",800,600);
    }
    
}
