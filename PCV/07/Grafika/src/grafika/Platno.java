/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author ucitel
 */
class Bod {
    public Point point;
    public Color color;
    public int radius;
    public boolean fill;
            
    public Bod(int x, int y, boolean fill) {
        this.point = new Point(x, y);
        int red = (int) Math.floor(Math.random() * 256);
        int green = (int) Math.floor(Math.random() * 256);
        int blue = (int) Math.floor(Math.random() * 256);
        this.color = new Color(red, green, blue);
        this.radius = (int) Math.floor(Math.random() * 21) + 10;
        this.fill = fill;
    }
}

public class Platno extends JComponent implements MouseListener, MouseMotionListener {
    private Point p = new Point(100,100);
    ArrayList<Bod> points;
    
    public Platno() {
        this.points = new ArrayList();
    }
    
    public void init() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);        
    }
    
    public void setPoint(int x, int y, boolean fill) {
        p = new Point(x,y);
        this.points.add(new Bod(p.x, p.y, fill));
    }
    
    public void drawPoints(Graphics g) {
        for (Bod b: this.points) {
            g.setColor(b.color);
            if (b.fill)
                g.fillOval(b.point.x - b.radius, 
                           b.point.y - b.radius, 
                           2*b.radius, 2*b.radius);
            else
                g.drawOval(b.point.x - b.radius, 
                           b.point.y - b.radius, 
                           2*b.radius, 2*b.radius);
        }
    }
    
    public void drawAxis(Graphics g, Dimension size) {
        g.setColor(Color.gray);
        g.drawLine(0, p.y, size.width, p.y);        
        g.drawLine(p.x, 0, p.x, size.height);        
    }
    
    public void paint(Graphics g) {
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
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println(me.getButton());
        if (me.getButton() == 1) {
            this.setPoint(me.getX(),me.getY(),false);
        }
        if (me.getButton() == 3) {
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
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        System.out.println("x:"+me.getX()+" y:"+me.getY());
    }
}
