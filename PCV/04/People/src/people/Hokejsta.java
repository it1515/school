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
public class Hokejsta extends Sportsman {
    private int goals = 0;
    private int assists = 0;

    public Hokejsta(String jmeno, int age, Sex sex, int energy) {
        super(jmeno, age, sex, energy);
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String toString(){
        return super.toString() + "Goals = " +this.goals + "\nAssists = " +this.assists+"\n";
    }
}
