/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.Graphics;

/**
 *
 * @author nesty
 */
public class Projectile extends Objekt {
    public int radius;
    public Projectile(int x, int y, boolean fill) {
        super(x, y, fill);
        this.radius = 5;
    }
    @Override
    public void setSize(int size){
        this.radius += size;
    }
    
    @Override
    public int getSize(){
        return this.radius;
    }
    
    @Override
    public void setSpeed(int speed){
        this.speed += speed;
    }
    
    @Override
    public int getSpeed(){
        return this.speed;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(this.color);
        if(this.fill)
            g.fillOval(this.point.x- this.radius,this.point.y- this.radius,2*this.radius,2*this.radius);
        else{
            g.drawOval(this.point.x- this.radius,this.point.y- this.radius,2*this.radius,2*this.radius);
        }
    }
      
    @Override
    public void animate(Platno p){
        //if(this.point.y + this.radius > p.getHeight() || this.point.y - this.radius < 0)
            //this.speed = 10;
        this.point.y += this.speed;
    }

    @Override
    public boolean detect(int x, int y) {
        double a = Math.pow(x - this.point.x,2);
        double b = Math.pow(y - this.point.y,2);
        return Math.sqrt(a+b) <= this.radius;
    }
    
}
