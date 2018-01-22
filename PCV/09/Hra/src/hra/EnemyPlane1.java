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
        //TODO: Fade barvy z červene do bile
        int red = (int)((200 / 20f) * health);
        int iNred = 255 - (int)((255f / 20f) * health);       
        Color color = new Color(255,iNred,iNred, red);
        g.setColor(color);
        g.drawRect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
    }
    
}
