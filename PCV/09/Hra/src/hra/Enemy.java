/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author student
 */
public abstract class Enemy {
    
    protected Rectangle bounds;
    protected int speed  = 3;
    protected int health = 5;
    protected boolean active = true;
    
    public Enemy(int x, int y, int w, int h) {
        this.bounds = new Rectangle(x, y, w, h);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }
    
    public void hurt(int damage){
        this.health -= damage;
        if(this.health <= 0){
            this.die();
        }
    }
    
    public boolean detectCollision(Point p, int r){
        return (this.bounds.contains(new Point(p.y - r, p.x)) || 
                this.bounds.contains(new Point(p.y, p.x + r)) || 
                this.bounds.contains(new Point(p.y, p.x - r)));
    }
    
    public void die(){
        this.active = false;
    }
    
    public void move(){
        this.bounds.y += this.speed;
    }

    public boolean isActive() {
        return active;
    }
    
    public abstract void paint(Graphics g);
    
}
