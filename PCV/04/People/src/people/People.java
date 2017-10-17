/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class People {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Human student = new Human("Hugo",18,Human.Sex.MAN);
        Human studentka = new Human("Hilda",17,Human.Sex.WOMAN);
        student.setWeight(75);
        studentka.setWeight(60);
        student.setHeight(1.85f);
        studentka.setHeight(1.72f);

//        System.out.println(student.toString());
//        System.out.println(studentka.toString());
        
        Human sportovec = new Hockeyplayer("Jarda",45,Human.Sex.MAN,20000);
        sportovec.setHeight(1.92f);
        sportovec.setWeight(95);
        ((Hockeyplayer) sportovec).setGoals(251);
        ((Hockeyplayer) sportovec).setAssists(298);
//        System.out.println(sportovec.toString());
        
        List<Human> lide = new ArrayList<Human>();
        lide.add(student);
        lide.add(studentka);
        lide.add(sportovec);
        
        for (Human clovek : lide){
            System.out.println(clovek.toString());
        }
    }
    
}
