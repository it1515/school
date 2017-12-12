/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics;

/**
 *
 * @author student
 */
public class Kruh extends Tvar{
    public int radius;
    
    public Kruh(int x, int y, boolean fill) {
        super(x, y, fill);
        this.radius = (int)Math.floor(Math.random()*20)+10;
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
            else
                g.drawOval(this.point.x- this.radius,this.point.y- this.radius,2*this.radius,2*this.radius);
    }
      
    @Override
    public void animate(Platno p){
        if(this.point.x - this.radius > p.getWidth())
            this.point.x = -this.radius;
        if(this.point.x + this.radius < 0)
            this.point.x = p.getWidth() + this.radius;
        this.point.x += this.speed;
    }

    @Override
    public boolean detect(int x, int y) {
        double a = Math.pow(x - this.point.x,2);
        double b = Math.pow(y - this.point.y,2);
        return Math.sqrt(a+b) <= this.radius;
    }
}
