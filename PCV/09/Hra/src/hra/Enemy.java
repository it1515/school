/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author student
 */
public abstract class Enemy {
    
    protected Rectangle bounds;
    protected int speed  = 3;
    protected int health = 5;
    protected int num;
    protected boolean active = true;
    
    public Enemy(int x, int y, int w, int h) {
        this.bounds = new Rectangle(x, y, w, h);
        Random rand = new Random();
        num = rand.nextInt(3)+1;
        randomHealth(num);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int rychlost) {
        speed = rychlost;
    }
    
    public void randomHealth(int rndCislo){
        if(rndCislo == 1){
            health = 5;
        }
        if(rndCislo == 2){
            health = 10;
        }
        if(rndCislo == 3){
            health = 20;
        }
    }

    public int getHealth() {
        return health;
    }
    
    public void hurt(int damage){
        this.health -= damage;
    }
    
    public boolean detectCollision(Point p, int r){
        return (this.bounds.contains(new Point(p.x, p.y - r)));
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
    
    public boolean impact(Rectangle rect) {
    	return rect.intersects(bounds);
    }
    
    public abstract void paint(Graphics g);
    
}
