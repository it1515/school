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
public class MeleeWeapon extends Weapon{
    public enum Type {
        SWORD, AXE, BLADE, MACE, HAMMER, SPEAR, DAGGER
    }
    private int length = 3;
    private Type type = Type.SWORD;
    
    public MeleeWeapon(String name, int dmg, int attackspeed, int range, int durability, Rarity rarity, int length, Type type){
        super(name, dmg, attackspeed, range, durability, rarity);
        this.setLength(length);
        this.setType(type);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;        
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }   
}
