/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponeditor;

/**
 *
 * @author student
 */
public class Weapon {
    public enum Rarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }
    private String name;
    private int dmg = 50;
    private int attackspeed = 2;
    private int range = 50;
    private int durability = 100;
    private Rarity rarity = Rarity.COMMON;

    public Weapon(String name, int dmg, int attackspeed, int range, int durability, Rarity rarity){
        this.setName(name);
        this.setDmg(dmg);
        this.setAttackspeed(attackspeed);
        this.setRange(range);
        this.setDurability(durability);
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
        String output = this.name + " [Weapon]\n";
        output += "DMG: "+this.dmg+"\n";
        output += "Attackspeed: "+this.attackspeed+"\n";
        output += "Range: "+this.range+" m\n";
        output += "Durability: "+this.durability+" %\n";
        return output;
    }
    
}
