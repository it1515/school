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
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;
/**
 *
 * @author student
 */


public class Platno extends JComponent implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
    private Point p = new Point(100,100);
    private boolean drag;
    ArrayList<Objekt> points;
    private Timer timer;
    private int meters;
    private Font myFont = new Font("Aerial", Font.BOLD, 18);
    public Platno() {
        this.points = new ArrayList();
    }
    
    public void setPoint(int x, int y,boolean fill){
        p = new Point(x,y);
        this.points.add(new Projectile(p.x,p.y,fill));
    }
    
    public void createObject(int x, int y,boolean fill){
        this.points.add(new Projectile(p.x,p.y,fill));
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
    
    public void drawPlayer(Graphics g,Dimension size){
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
        g2.draw(new Rectangle2D.Double(p.x-rectwidth/2,size.height-60,rectwidth,rectheight));
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
     
    public void drawDistance(Graphics g,Dimension size){
        String str = "Distance: ";
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(myFont);
        g2.setColor(Color.black);
        g2.drawString(str, size.width-170, size.height-80);
    }
    
    public void drawPoints(Graphics g){
        for(Objekt o: this.points){
            o.paint(g);
        }

    }
    
    public void paint(Graphics g){   
        g.setColor(Color.gray);
        //g.drawImage(img, 0, 0, null);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        //drawAxis(g, size);
        drawPlayer(g,size);
        drawCrosshair(g);
        drawDistance(g,size);
        drawPoints(g);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println(me.getButton());
        if (me.getButton() == 1) {
            this.setPoint(me.getX(),this.getHeight()-60,true);
        }
        if (me.getButton() == 2) {
            this.setPoint(me.getX(),me.getY(),false);
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

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //System.out.println("x:"+me.getX()+" y:"+me.getY());
        p.x = me.getX();
        p.y = me.getY();
        this.repaint();
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for(Objekt o: this.points){
            o.animate(this);
        }
    }
    
}
