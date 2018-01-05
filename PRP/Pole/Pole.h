/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Pole.h
 * Author: student
 *
 * Created on 5. ledna 2018, 11:48
 */

#ifndef POLE_H
#define POLE_H

class Pole {
public:
    Pole();
    Pole(int);
    Pole(const Pole& orig);
    virtual ~Pole();
    bool napln();
    void vypis() const;
    void vypis(int) const;
    bool pridej(int);
    bool vymaz(int);
    bool vloz(int,int);
private:
    int * adresa; // adresa počatku pole
    int pocetPrvku;

};

#endif /* POLE_H */

