/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: student
 *
 * Created on 16. února 2018, 11:44
 */

#include <cstdlib>
#include <iostream>

#include "Retezec.hpp"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    char * neco = "Ez string";
    char * str2 = "String neni ez";
    char * str3 = " Pridany string !";
    char * str4 = " HAHA(-_-)HAHA ";
    char * ch1;
    Retezec r1(neco);
    Retezec r2(str2);
    Retezec r3(str3);
    Retezec r4(str4);
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    r1.prepisRetezec("Prepsany retezec");
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
//    cout << "Zapise do retezce r1: " << r1.vypisRetezec();
//    cin >> ch1;
    r1.pridejKRetezci("a neco");
//    cout << "Zapise do retezce r1: " << r1.vypisRetezec();
//    cin >> ch2;
//    r1.pridejKRetezci(ch2);
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    r1.vymazRetezec();
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    r1 = r2;
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    r1 += r3;
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    r1.vymazRetezec();
    r1 = r4 + r2 + r3 + r4;
    cout << "Vypsany retezec r1: " << r1.vypisRetezec() << " [" << r1.getPocetPrvku() << "]" << endl;
    return 0;
}

