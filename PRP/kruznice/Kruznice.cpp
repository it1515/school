/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Kruznice.cpp
 * Author: student
 * 
 * Created on 29. září 2017, 11:54
 */

#include "Kruznice.h"
#include <cmath>

Kruznice::Kruznice() {
    this->r = 1;
}

Kruznice::Kruznice(float r) {
    if(r <= 0){
        this->r=1;
    }else{
        this->r=r;    
    }
}

bool Kruznice::setPolomer(float r){
    if(r <= 0){
        return false;
    }
    this->r=r;  
    return true;
}

float Kruznice::getPolomer() const{
    return this->r;
}

float Kruznice::obvod() const{
    return 2 * M_PI * this->r;
}

float Kruznice::obsah() const{
    return M_PI * this->r * this->r;
}

Kruznice::~Kruznice() {
}

