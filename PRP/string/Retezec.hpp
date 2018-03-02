/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Retezec.hpp
 * Author: student
 *
 * Created on 16. února 2018, 11:46
 */

#ifndef RETEZEC_HPP
#define RETEZEC_HPP

class Retezec {
public:
    Retezec();
    Retezec(char *);
    Retezec(const Retezec& orig);
    char * vypisRetezec() const;
    bool prepisRetezec(char *);
    bool vymazRetezec();
    bool pridejKRetezci(char *);
    int getPocetPrvku() const;
    virtual ~Retezec();
    char operator[](int) const;
    char &operator[](int);
    Retezec &operator = (const Retezec&);
    Retezec &operator += (const Retezec&);
    Retezec operator + (const Retezec&) const;
private:
    char * retezec;
    int pocetPrvku;
};

#endif /* RETEZEC_HPP */

