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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
/**
 *
 * @author student
 */


@SuppressWarnings("serial")
public class Platno extends JComponent implements MouseListener, MouseMotionListener, KeyListener, ActionListener {

	private Point p = new Point(100,100);
	static ArrayList<Objekt> points;
    static ArrayList<Enemy> enemies;
    private Timer timer;
    public Image img;
    public Image letadlo;
    private Rectangle playerRect;
    private float meters = 1f;
    private int kills = 0;
    private int score = 0;
    private Font myFont = new Font("Aerial", Font.BOLD, 18);
    private Font myFont2 = new Font("Aerial", Font.BOLD, 58);
    public Platno(){
    	this.points = new ArrayList<Objekt>();
    	this.enemies = new ArrayList<Enemy>();
        
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
    
    public void init(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this); 
        this.addKeyListener(this);
        this.setFocusable(true);
        img = new ImageIcon(getClass().getResource("img/mapp.jpg")).getImage(); // 800x 2952
        letadlo = new ImageIcon(getClass().getResource("img/letadlo.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        this.timer = new Timer(30,this);
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
        if(timer.isRunning()){
        Graphics2D g2 = (Graphics2D) g;
        float tloustka = 3f;
        int rectwidth=80;
        int rectheight=40;
        BasicStroke stroke = new BasicStroke(tloustka,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);
        g2.setColor(Color.blue);
        playerRect = new Rectangle(p.x-rectwidth/2,size.height-70,rectwidth,rectheight);
        g2.draw(playerRect);
        g2.drawImage(letadlo,p.x-rectwidth/2,size.height-88,null);
        }
    }
    
     public void drawCrosshair(Graphics g){
        if(timer.isRunning()){
            Graphics2D g2 = (Graphics2D) g;
            float tloustka = 2f;
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
    }
     
    public void drawText(Graphics g,Dimension size){
        if(timer.isRunning()){
            if((int)meters % 200 == 0)
                this.spawnRndEnemyLine();
            String str = "Distance: " + (int)(meters/2);
            String str2 = "Kills: " + kills;
            score = (int)meters + kills * 200;
            String str3 = "Score: " + score;
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(myFont);
            g2.setColor(Color.gray);
            g2.drawString(str, size.width-170, size.height-80);
            g2.drawString(str2, size.width-170, size.height-60);
            g2.drawString(str3, size.width/2 -60, 60);
        }
    }
    
    public void drawPoints(Graphics g){
        for(Objekt o: this.points){
            o.paint(g);
        }
    }
    
    public void drawEnemies(Graphics g){
        for(Enemy e: this.enemies){
            e.paint(g);
        }
    }
    
    public void drawBackground(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int endOfImg = -2352;
        int sizeOfImg = 2952;
        endOfImg+=(int)(meters*5);
        g2d.drawImage(img,0,endOfImg,null);
        for(int i=0;i<meters;i++){
            if(endOfImg > (i * 2952)){
                g2d.drawImage(img,0,endOfImg - (sizeOfImg*(i+1)),null);
            }
        }
    }
    
    public void drawEndGame(Graphics g,Dimension size){
        if(!timer.isRunning()){
            String str = "Score: " + score;
            String str2 = "GAME OVER";
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(myFont2);
            g2.setColor(Color.red);     
            g2.drawString(str, size.width/2 -120, 290);
            g2.drawString(str2, size.width/2 -120, 220);
        }
    }
    
    public void paint(Graphics g){   
        g.setColor(Color.gray);   
        //g.drawImage(img, 0, 0, null);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        //drawAxis(g, size);
        drawBackground(g);
        drawPlayer(g,size);
        drawCrosshair(g);
        drawText(g,size);
        drawPoints(g);
        drawEnemies(g);
        drawEndGame(g,size);
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
            this.setPoint(me.getX(),this.getHeight()-70,true);
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
        p.x = me.getX();
        p.y = me.getY();
        this.repaint();
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
        switch(ke.getKeyCode()){
            case KeyEvent.VK_UP:
                timer.stop();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        Iterator<Objekt> objIt;
        Iterator<Enemy> enmIt = this.enemies.iterator();
        
        while(enmIt.hasNext()){
            Enemy e = enmIt.next();
            
            if(!e.isActive()){
                enmIt.remove();
            }else{
                objIt = this.points.iterator();
                while(objIt.hasNext()){
                    Objekt o = objIt.next();
                    if(e.detectCollision(o.getPoint(), o.getSize())){
                        e.hurt(o.getDamage());
                        o.die();
                        if(e.getHealth() <= 0){
                            e.die();
                            kills++;
                        }
                    }
                }
                e.move();
                if(e.impact(playerRect)) {
                    timer.stop();                 
                }
            }
            if(meters < 600){
                e.setSpeed(3);
            }
            if(meters >= 600 && meters < 1800){
                e.setSpeed(5);
            }
            if(meters >= 1800 && meters < 4800){
                e.setSpeed(8);
            }
            if(meters >= 4800){
                e.setSpeed(12);
            }
        }
        
        objIt = this.points.iterator();
        
        while(objIt.hasNext()){
            Objekt o = objIt.next();
            if(!o.isActive()){
                objIt.remove();
            }else{
                o.animate(this);
            }   
        }     
        if(meters < 600){
            meters++;
        }
        if(meters >= 600 && meters < 1800){
            meters += 2;
        }
        if(meters >= 1800 && meters < 4800){
            meters += 4;
        }
        if(meters >= 4800){
            meters += 8;
        }
        this.repaint();
    }
    
    public static void spawnRndEnemyLine() {
        Random rand = new Random();
        int count = 9;
    	for(int i = 0; i < count; i++) {         
                int num = rand.nextInt(2);
                if(num==1)
                    enemies.add(new EnemyPlane1(((Hra.getWidth() / count) * i) + (Hra.getWidth() / count) / 2 - 40, -40));
    	}
    	
    }
    
}
