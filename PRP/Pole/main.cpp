/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: student
 *
 * Created on 5. ledna 2018, 11:47
 */

#include <cstdlib>
#include <iostream>

#include "Pole.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int cislo,index;
    Pole p1;
    Pole p2(10);
    if(p2.napln()){
        p2.vypis(5);
    }
    cout << "Zadejte cislo: ";
    cin >> cislo;
    if(p2.pridej(cislo))
        p2.vypis();
    do{
    cout << "Zadejte index: ";
    cin >> index;
    cout << "Zadejte cislo: ";
    cin >> cislo;    
    if(p2.vloz(cislo,index))
        p2.vypis();
    }while(1);
    return 0;
}

