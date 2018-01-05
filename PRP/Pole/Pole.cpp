/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Pole.cpp
 * Author: student
 * 
 * Created on 5. ledna 2018, 11:48
 */

#include "Pole.h"
#include <ctime>
#include <cstdlib>
#include <iostream>

Pole::Pole() {
    this->adresa = nullptr;
    this->pocetPrvku = 0;
}
Pole::Pole(int pocet){
    if(pocet <= 0)
    {
        this->pocetPrvku = 0;
        this->adresa = nullptr;
    }
    else
    {
        this->adresa = new int[pocet];
        if(this->adresa != nullptr)
            this->pocetPrvku = pocet;
        else
            this->pocetPrvku = 0;
    }
}

Pole::Pole(const Pole& orig) {
}

Pole::~Pole() {
    if(this->adresa != nullptr)
    {
        delete[] this->adresa;
        this->pocetPrvku = 0;
    }    
}

bool Pole::napln(){
    srand((unsigned)time(NULL));
    if(this->adresa != nullptr)
    {
        for(int i = 0; i < this->pocetPrvku; i++)
        {
            this->adresa[i] = rand()%99+1;
        }
        return true;
    }
    else
        return false;
}

void Pole::vypis() const {
    if(this->adresa != nullptr)
    {
        for(int i = 0; i < this->pocetPrvku; i++)
        {
            std::cout << this->adresa[i] << std::endl;
        }
    }
    else
        std::cout << "Pole neexistuje" << std::endl;
}

void Pole::vypis(int pocet) const{
    if(this->adresa != nullptr && pocet <= this->pocetPrvku)
    {
        for(int i = 0; i < pocet; i++)
        {
            std::cout << this->adresa[i] << std::endl;
        }
    }
    else
        std::cout << "Pole neexistuje nebo nema " << pocet << " poli" << std::endl;
}

bool Pole::pridej(int cislo) {
    int * tmp = new int[this->pocetPrvku + 1];
    if(tmp != nullptr)
    {
        for(int i = 0; i < pocetPrvku; i++)
        {
            tmp[i] = this->adresa[i];
        }        
        tmp[this->pocetPrvku] = cislo;
        this->pocetPrvku++;
        delete [] this->adresa;
        this->adresa = tmp;
        return true;
    }
    else
        return false;
}

bool Pole::vymaz(int index){
    if(index >= 0 && index < this->pocetPrvku)
    {
        if(pocetPrvku > 1)
        {
        int * tmp = new int[this->pocetPrvku - 1];
        if(tmp != nullptr)
        {
            for(int i = 0; i < index;i++)
            {
                tmp[i] = this->adresa[i];
            }
            for(int i = index; i < pocetPrvku-1; i++)
            {
                tmp[i] = this->adresa[i+1];
            }
            
        }
        this->pocetPrvku--;
        delete [] this->adresa;
        this->adresa = tmp;
        return true;    
        }
        else
        {
            delete [] this->adresa;
            this->adresa = nullptr;
            this->pocetPrvku = 0;
        }
    }
    else
        return false;
}

bool Pole::vloz(int cislo, int index){
    if(index >= 0 && index < this->pocetPrvku)
    {
        int * tmp = new int[this->pocetPrvku + 1];
        if(tmp != nullptr)
        {
            for(int i = 0; i < index; i++)
            {
                tmp[i] = this->adresa[i];
            }           
            tmp[index] = cislo;  
            for(int i = index; i < pocetPrvku+1; i++)
            {
                tmp[i+1] = this->adresa[i];
            }    
            delete [] this->adresa;
            this->adresa = tmp;
            this->pocetPrvku++;      
            return true;
        }
        else
            return false;
    }    
}