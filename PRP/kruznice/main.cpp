/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: student
 *
 * Created on 29. září 2017, 11:53
 */

#include <cstdlib>
#include <iostream>
#include "Kruznice.h"

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char** argv) {
    
    float buffer;

    Kruznice k1;
    Kruznice k2(2.4);
    
    cout << "Objekt k1: " << k1.getPolomer() << endl;
    cout << "Objekt k2: " << k2.getPolomer() << endl;
    
    cout << "Zadej polomer pro k1:";
    cin >> buffer;
    if(k1.setPolomer(buffer)){
        cout << "Byla ulozena hodnota: " << k1.getPolomer() << endl;
    }else{
        cout << "Spatne zadana hodnota.";
    }
    cout << "Objekt k1: " << k1.obvod() << endl;
    cout << "Objekt k1: " << k1.obsah() << endl;
    
    cout << "Objekt k2: " << k2.obvod() << endl;
    cout << "Objekt k2: " << k2.obsah() << endl;
    return 0;
}

