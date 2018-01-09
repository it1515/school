/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author student
 */


public class Platno extends JComponent implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
    private Point p = new Point(100,100);
    private boolean drag;
    private Timer timer;
    
    public Platno() {

    }
    
    public void setPoint(int x, int y,boolean fill){
        p = new Point(x,y);
    }
    
    public void setAxis(int x, int y){
        
    }
    
    public void init() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this); 
        this.addKeyListener(this);
        this.setFocusable(true);
        this.timer = new Timer(50,this);
        timer.start();
    }
    
    
    public void drawAxis(Graphics g, Dimension size){
        Graphics2D g2d = (Graphics2D) g;
        float tloustka = 1f;
        float miterLimit = 2f;
        float[] dashPattern = {5f};
        float dashPhase = 5f;
        BasicStroke stroke = new BasicStroke(tloustka,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,miterLimit,dashPattern,dashPhase);
        g2d.setStroke(stroke);
        g2d.setColor(Color.black);
        g2d.drawLine(0, p.y, size.width, p.y);
        g2d.drawLine(p.x, 0, p.x, size.height);
    }
    
    public void drawPlayer(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        float tloustka = 3f;
        float miterLimit = 5f;
        float[] dashPattern = {1f};
        float dashPhase = 5f;
        int rectwidth=80;
        int rectheight=40;
        BasicStroke stroke = new BasicStroke(tloustka,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);
        g2.setColor(Color.blue);
        //g2d.drawLine(0, p.y, size.width, p.y);
        //g2d.drawLine(p.x, 0, p.x, size.height);
        g2.draw(new Rectangle2D.Double(p.x-rectwidth/2,420,rectwidth,rectheight));
    }
    
     public void drawCrosshair(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        float tloustka = 2f;
        float miterLimit = 5f;
        float[] dashPattern = {1f};
        float dashPhase = 5f;
        int crossW=30;
        int crossH=30;
        BasicStroke stroke = new BasicStroke(tloustka,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);
        g2.setColor(Color.green);
        //g2d.drawLine(0, p.y, size.width, p.y);
        //g2d.drawLine(p.x, 0, p.x, size.height);
        g2.draw(new Rectangle2D.Double(p.x-crossW/2,p.y,crossW,0));
        g2.draw(new Rectangle2D.Double(p.x,p.y-crossH/2,0,crossH));
    }
     
    public void drawDistance(Graphics g){ 
        String str = "Distance: ";
        Graphics2D g2 = (Graphics2D) g;
        //g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2.setColor(Color.black);
        g2.drawString(str, 600, 420);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        //drawAxis(g, size);
        drawPlayer(g);
        drawCrosshair(g);
        drawDistance(g);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == 1) {
            drag = true;
        }
        if (me.getButton() != 1){
            drag = false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println(me.getButton());
        if (me.getButton() == 3) {
            this.setPoint(me.getX(),me.getY(),false);
        }
        if (me.getButton() == 2) {
            this.setPoint(me.getX(),me.getY(),true);
        }
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if(drag){
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //System.out.println("x:"+me.getX()+" y:"+me.getY());
      
        this.setPoint(me.getX(),me.getY(),true);
        p.x = me.getX();
        p.y = me.getY();
        this.repaint();
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    //nahoru 38, dolu 40, doprava 39, doleva 37
        
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:
                this.setPoint(400, 200, true);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.repaint();
    }
    
}
