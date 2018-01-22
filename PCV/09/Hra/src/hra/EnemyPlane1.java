/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author student
 */
public class EnemyPlane1 extends Enemy{

    private Image texture;
    
    public EnemyPlane1(int x, int y) {
        super(x, y, 80, 40);
        texture = new ImageIcon(getClass().getResource("img/letadlo.png")).getImage().getScaledInstance(this.bounds.width, this.bounds.height, Image.SCALE_DEFAULT);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(texture, this.bounds.x, this.bounds.y-20, this.bounds.width, this.bounds.height+40, null);
        if(num==1)
            g.setColor(Color.BLUE);
        if(num==2)
            g.setColor(Color.GREEN);
        if(num==3)
            g.setColor(Color.RED);
        g.drawRect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }
    
}
