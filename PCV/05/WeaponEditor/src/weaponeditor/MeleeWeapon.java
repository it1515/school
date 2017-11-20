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
        Sword, Axe, Blade, Mace, Hammer, Spear, Dagger
    }
    private int length = 3;
    private Type type = Type.Sword;
    
    public MeleeWeapon(String name, int dmg, int attackspeed, int range, int durability, Rarity rarity, int length, Type type){
        super(name, dmg, attackspeed, range, durability, rarity);
        this.setLength(length);
        this.setType(type);
    }
    
    public MeleeWeapon(String name, int dmg, Type type){
        super(name, dmg);
        this.setType(type);
    }
    
    public MeleeWeapon(String name, Type type, Rarity rarity){
        super(name, rarity);
        this.setType(type);
    }
    
    public MeleeWeapon(String name, Type type){
        super(name);
        this.setType(type);
    }
    
    public MeleeWeapon(String name){
        super(name);
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
    public String toString(){
        return super.toString() + "["+this.type+"]\n";
    }
}
