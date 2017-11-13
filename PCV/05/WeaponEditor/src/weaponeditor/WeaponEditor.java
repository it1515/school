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
public class WeaponEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MeleeWeapon Mec = new MeleeWeapon("Mec",2000,MeleeWeapon.Type.Sword);
        RangeWeapon Raketomet = new RangeWeapon("Raketomet",800,RangeWeapon.Type.RocketLauncher);
        System.out.println(Mec.toString());
        System.out.println(Raketomet.toString());
    }
    
}
