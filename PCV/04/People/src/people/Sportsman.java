/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author student
 */
public class Sportsman extends Human {
    private int energy = 15000;
    private double steroid = 0;
    public Sportsman(String jmeno, int age, Sex sex, int energy) {
        super(jmeno, age, sex);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getSteroid() {
        return steroid;
    }

    public void setSteroid(double steroid) {
        this.steroid = steroid;
    }
    
     @Override
    public String toString(){
        return super.toString() + "Sportsman " + "energy = " +this.energy + "\n";
    }
}
