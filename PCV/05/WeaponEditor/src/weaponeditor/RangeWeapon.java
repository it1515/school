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
public class RangeWeapon extends Weapon{
    public enum Type {
        Bow, Crossbow, Pistol, Smg, Assult, Sniper, RocketLauncher
    }
    private int accuracy = 50;
    private int stability = 50;
    private int ammoCapacity = 90;
    private int magazineCapacity = 30;
    private Type type = Type.Bow;
    
    public RangeWeapon(String name, int dmg, int attackspeed, int range, int durability, Rarity rarity, int accuracy,
            int stability, int ammoCapacity, int magazineCapacity, Type type){
        super(name, dmg, attackspeed, range, durability, rarity);
        this.setAccuracy(accuracy);
        this.setStability(stability);
        this.setAmmoCapacity(ammoCapacity);
        this.setMagazineCapacity(magazineCapacity);
        this.setType(type);
    }
    
    public RangeWeapon(String name, int dmg, Type type){
        super(name, dmg);
        this.setType(type);
    }
    
    public RangeWeapon(String name, Type type){
        super(name);
        this.setType(type);
    }
    
    public RangeWeapon(String name){
        super(name);
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getStability() {
        return stability;
    }

    public void setStability(int stability) {
        this.stability = stability;
    }

    public int getAmmoCapacity() {
        return ammoCapacity;
    }

    public void setAmmoCapacity(int ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    public int getMagazineCapacity() {
        return magazineCapacity;
    }

    public void setMagazineCapacity(int magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
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
