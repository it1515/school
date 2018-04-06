/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Matice.hpp
 * Author: student
 *
 * Created on 6. dubna 2018, 12:19
 */

#ifndef MATICE_HPP
#define MATICE_HPP

class Matice {
public:
    Matice();
    Matice(int,int);
    Matice(const Matice& orig);
    virtual ~Matice();
    int getValue(int,int) const;
    int getRows() const;
    int getColumns() const;
private:
    int **pointOnPoint; // Pointer On Pointer (Array of pointers)
    int rows;
    int columns;
    void deletePointerArray();
    void makePointerArray();
};

#endif /* MATICE_HPP */

