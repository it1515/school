/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author student
 */
class Bod {
    public Point point;
    public Color color;
    public int radius;
    public boolean fill;
    public Bod(int x, int y,boolean fill){
        this.point = new Point(x,y);
        int red = (int)Math.floor(Math.random()*256);
        int green = (int)Math.floor(Math.random()*256);
        int blue = (int)Math.floor(Math.random()*256);
        this.color = new Color(red,green,blue);
        this.radius = (int)Math.floor(Math.random()*20)+10;
        this.fill = fill;
    }
}

public class Platno extends JComponent implements MouseListener, MouseMotionListener, KeyListener {
    private Point p = new Point(100,100);
    private boolean drag;
    ArrayList<Bod> points;
    
    public Platno() {
        this.points = new ArrayList();
    }
    
    public void setPoint(int x, int y,boolean fill){
        p = new Point(x,y);
        this.points.add(new Bod(p.x,p.y,fill));
    }
    
    public void setAxis(int x, int y){
        
    }
    
    public void init() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this); 
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    public void drawPoints(Graphics g){
        for(Bod b: this.points){
            g.setColor(b.color);
            if(b.fill)
            g.fillOval(b.point.x- b.radius,b.point.y- b.radius,2*b.radius,2*b.radius);
            else
            g.drawOval(b.point.x- b.radius,b.point.y- b.radius,2*b.radius,2*b.radius);
        }
    }
    
    public void drawAxis(Graphics g, Dimension size){
        Graphics2D g2d = (Graphics2D) g;
        float tloustka = 1f;
        float miterLimit = 20f;
        float[] dashPattern = {5f};
        float dashPhase = 5f;
        BasicStroke stroke = new BasicStroke(tloustka,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,miterLimit,dashPattern,dashPhase);
        g2d.setStroke(stroke);
        g2d.setColor(Color.gray);
        g2d.drawLine(0, p.y, size.width, p.y);
        g2d.drawLine(p.x, 0, p.x, size.height);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        drawAxis(g, size);
        drawPoints(g);
        
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
        Bod b = this.points.get(this.points.size()-1);
        b.point.x = me.getX();
        b.point.y = me.getY();
        p.x = me.getX();
        p.y = me.getY();
        this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        System.out.println("x:"+me.getX()+" y:"+me.getY());
        //this.setPoint(me.getX(),me.getY(),true);
        p.x = me.getX();
        p.y = me.getY();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        Bod b = this.points.get(this.points.size()-1);
    //nahoru 38, dolu 40, doprava 39, doleva 37
        
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:
                p.y--;
                b.point.y--;
                break;
            case KeyEvent.VK_DOWN:
                p.y++;
                b.point.y++;
                break;
            case KeyEvent.VK_RIGHT:
                p.x++;
                b.point.x++;
                break;
            case KeyEvent.VK_LEFT:
                p.x--;
                b.point.x--;
                break;
            case KeyEvent.VK_INSERT:
                this.setPoint(p.x, p.y, true);
                break;
            case KeyEvent.VK_PAGE_UP:
                b.radius++;
                break;
            case KeyEvent.VK_PAGE_DOWN:
                b.radius--;
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
