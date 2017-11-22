/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponeditor;

import java.util.Random;

/**
 *
 * @author student
 */
public class Weapon {

    void setType(MeleeWeapon.Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setType(RangeWeapon.Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLenght(int lenght) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Rarity {
        Common, Uncommon, Rare, Epic, Legendary;

        static Rarity getRandomRarity(){
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
    private String name;
    private int dmg = 50;
    private int attackspeed = 2;
    private int range = 50;
    private int durability = 100;
    private Rarity rarity = Rarity.Common;

    public Weapon(String name, int dmg, int attackspeed, int range, int durability, Rarity rarity){
        this.setName(name);
        this.setDmg(dmg);
        this.setAttackspeed(attackspeed);
        this.setRange(range);
        this.setDurability(durability);
        this.setRarity(rarity);
    }
    
    public Weapon(String name, int dmg){
        this.setName(name);
        this.setDmg(dmg);
    }
    
    public Weapon(String name , Rarity rarity){
        this.name = name;
        this.setRarity(rarity);
    }
    
    public Weapon(String name){
        this.name = name;
    }
    
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(int attackspeed) {
        this.attackspeed = attackspeed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
    
    
    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
    @Override
    public String toString(){
        String output = this.name + " ["+this.rarity+"]";
//        output += "DMG: "+this.dmg+"\n";
//        output += "Attackspeed: "+this.attackspeed+"\n";
//        output += "Range: "+this.range+" m\n";
//        output += "Durability: "+this.durability+" %\n";
//        output += "Rarity: "+this.rarity+"\n";
        return output;
    }
    
}
