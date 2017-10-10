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
public class Human {
    public enum Sex {
        MAN, WOMAN
    }
    private String name;
    private int age = 20;
    private int weight = 70;
    private float height = (float) 1.80;
    private Sex sex = Sex.MAN;
    
    public Human(String jmeno, int age, Sex sex){
        this.name = jmeno;
        this.setAge(age);
        this.setSex(sex);
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        if(age > 0 && age < 130)
            this.age = age;       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    public double getBMI(){
        return Math.round(this.weight/Math.pow(height,2)*100.0)/100.0;
    }
    
    @Override
    public String toString(){
        String output = "Name: "+ this.name+ "\n";
        output += "Age: "+this.age+" years\n";
        output += "Weight: "+this.weight+" kg\n";
        output += "Height: "+this.height+"m\n";
        output += "Sex: "+this.sex+"\n";
        output += "BMI: "+this.getBMI()+"\n";
        return output;
    }
}
