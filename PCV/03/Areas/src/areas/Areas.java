/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class Areas {
    Scanner sc = new Scanner(System.in,"UTF-8");
    enum Options{
        S, R, T, C, X;
    }

    float readNumber(String text) {
        float input = -1;
        do {
            try {
               System.out.print(text + ": ");
               input = sc.nextFloat();
               if(input < 0){
                   System.out.println("Číslo nesmí být záporné");
               }
            } catch(InputMismatchException e){
                System.out.println("Nesprávně zadané číslo!");
            }
            sc.nextLine();
        } while (input < 0);
        return input;
    }
    
    double getSquareArea(float a){
        return Math.pow(a,2);
    }
    
    float getRectangleArea(float a,float b){
        return (a*b);
    }
    
    float getTriangleArea(float a,float b){
        return (a*b/2);
    }
    
    double getCircleArea(float a){
        return Math.pow(a,2)* Math.PI;
    }
    
    void menu(){
        String optChar = "";
        do{
            System.out.println("Vypocet plochy geometrickych utvaru");
            System.out.println("---------------------------------------");
            System.out.println("S = Čtverec, R = Obdelník, T = Trojúhelník, C = Kruh, X = Zavřítx");
            System.out.println("zadej volbu");
            optChar = sc.nextLine();
            try {
                Options option = Options.valueOf(optChar.toUpperCase());
                switch(option){
                    case S: System.out.println("Čtverec");
                        float a1 = this.readNumber("Zadej stranu a");
                        System.out.printf("Plocha čtverce o straně a = %.2f je %.3f\n",a1,this.getSquareArea(a1));
                        break;
                    case R: System.out.println("Obdelník");
                        float a = this.readNumber("Zadej stranu a");
                        float b = this.readNumber("Zadej stranu b");
                        System.out.printf("Plocha obdelníku o stranach a = %.2f, b = %.2f je %.3f\n",a,b,this.getRectangleArea(a,b));
                        break;
                    case T: System.out.println("Trojúhelník");
                        float a2 = this.readNumber("Zadej stranu a");
                        float vyskaA = this.readNumber("Zadej výšku na stranu a");
                        System.out.printf("Plocha trojuhelníku o straně a = %.2f, a výšce = %.2f je %.3f\n",a2,vyskaA,this.getTriangleArea(a2,vyskaA));
                        break;
                    case C: System.out.println("Kruh");
                        float polomer = this.readNumber("Zadej poloměr kruhu");
                        System.out.printf("Plocha kruhu o poloměru = %.2f je %.3f\n",polomer,this.getCircleArea(polomer));
                        break;
                }
            }catch (Exception e) {
                System.out.println("Chybná volba");
            }
            
        }while(!optChar.equalsIgnoreCase("X"));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Areas areas = new Areas();
        areas.menu();
    }
    
}
