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

        System.out.println(student.toString());
        System.out.println(studentka.toString());
    }
    
}
