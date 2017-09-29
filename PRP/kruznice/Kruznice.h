/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Kruznice.h
 * Author: student
 *
 * Created on 29. září 2017, 11:54
 */

#ifndef KRUZNICE_H
#define KRUZNICE_H

class Kruznice {
public:
    Kruznice();
    Kruznice(float);
    bool setPolomer(float);
    float getPolomer() const;
    float obsah() const;
    float obvod() const;
    virtual ~Kruznice();
private:
    float r;
};

#endif /* KRUZNICE_H */

