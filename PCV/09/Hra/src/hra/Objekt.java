/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author nesty
 */
abstract class Objekt {
    protected Point point;
    protected Color color;
    protected int speed;
    protected boolean fill;
    protected Objekt(int x, int y, boolean fill){
        this.point = new Point(x,y);
        int red = (int)Math.floor(Math.random()*256);
        int green = (int)Math.floor(Math.random()*256);
        int blue = (int)Math.floor(Math.random()*256);
        this.color = new Color(red,green,blue); 
        this.speed = -10;
    }
    abstract public void setSize(int size);
    abstract public int getSize();
    abstract public void setSpeed(int speed);
    abstract public int getSpeed();
    abstract public boolean detect(int x, int y);
    abstract public void paint(Graphics g);
    abstract public void animate(Platno p);
}
