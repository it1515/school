/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Retezec.cpp
 * Author: student
 * 
 * Created on 16. února 2018, 11:46
 */
#include <cstring>
#include <cstdlib>
#include "Retezec.hpp"

Retezec::Retezec() {
    this->retezec;
    this->pocetPrvku = 0;
}

Retezec::Retezec(char* pridanyRetezec){
    this->retezec = (char *)malloc(strlen(pridanyRetezec)); //strlen(pridanyRetezec)
    if(this->retezec != NULL)
        strcpy(this->retezec, pridanyRetezec);
}

Retezec::Retezec(const Retezec& orig) {
    this->retezec = new char[orig.getPocetPrvku()];
    if(this->retezec != nullptr)
    {
        for(int i = 0; i < orig.getPocetPrvku(); i++)
        {
            this->retezec[i]=orig[i];       
        }
        this->pocetPrvku = orig.getPocetPrvku();
    }
    else
        this->pocetPrvku = 0;
}

Retezec::~Retezec() {
}

char * Retezec::vypisRetezec() const {
    return this->retezec;
}

bool Retezec::prepisRetezec(char* pridanyRetezec) {
    this->retezec = (char *)malloc(strlen(pridanyRetezec)); //strlen(pridanyRetezec)
    if(this->retezec != NULL){
        strcpy(this->retezec, pridanyRetezec);
        return true;
    }
    return false;
}

bool Retezec::vymazRetezec() {
    if(this->retezec != NULL){
        strcpy(this->retezec,"\0");
        return true;
    }
    return false;
}

int Retezec::getPocetPrvku() const {
    return strlen(this->retezec);
}

bool Retezec::pridejKRetezci(char* pridanyRetezec) {    
    if (pridanyRetezec != NULL){
        this->retezec = (char *)malloc(strlen(pridanyRetezec)+strlen(this->retezec));
        strcat(this->retezec,pridanyRetezec);
        return true;
    }
    else
        return false;
}

char Retezec::operator [] (int index) const {
    if(index >= 0 &&index < this->getPocetPrvku())
    {
        return this->retezec[index];
    }
    else
    {
        return this->retezec[0];
    }
}

char &Retezec::operator [] (int index) {
    if(index >= 0 &&index < this->getPocetPrvku())
    {
        return this->retezec[index];
    }
    else
    {
        return this->retezec[0];
    }
}

Retezec &Retezec::operator =(const Retezec& vpravo){
    if(this != &vpravo)
    {
        delete[] this->retezec;
        this->retezec = new char[vpravo.getPocetPrvku()];
        if(this->retezec != nullptr)
        {
            for(int i = 0; i < vpravo.getPocetPrvku(); i++)
            {
                this->retezec[i]=vpravo[i];
                this->pocetPrvku = vpravo.getPocetPrvku();
            }
        }
    }
    return *this;
}

Retezec &Retezec::operator +=(const Retezec& vpravo){
    char *temp = new char[this->getPocetPrvku() + vpravo.getPocetPrvku()+1];
    if(this != &vpravo)
    {
        int i = 0;
        for(;i < this->getPocetPrvku();i++)
        {
            temp[i] = this->retezec[i];
        }
        for(;i<this->getPocetPrvku() + vpravo.getPocetPrvku();i++)
        {
            temp[i] = vpravo[i-this->getPocetPrvku()];
        }
        delete[] this->retezec;
        this->retezec = temp;
        this->pocetPrvku = this->getPocetPrvku() + vpravo.getPocetPrvku();
        this->retezec[i] = '\0';
    }
    
    return *this;
}

Retezec Retezec::operator +(const Retezec& vpravo) const{
    Retezec temp(*this);
    temp += vpravo;
    return temp;
}