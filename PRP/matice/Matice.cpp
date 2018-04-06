/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Matice.cpp
 * Author: student
 * 
 * Created on 6. dubna 2018, 12:19
 */

#include "Matice.hpp"

Matice::Matice() {
    this->pointOnPoint = nullptr;
    this->rows = 0;
    this->columns = 0;
}

// Konstruktor matice
Matice::Matice(int rows,int columns) {
    if(rows > 0 && columns > 0){
        this->pointOnPoint = new int*[rows];
        if(this->pointOnPoint != nullptr){
            this->rows = rows;
            this->columns = columns;
            for(int i = 0; i<rows; i++){
                pointOnPoint[i] = new int[columns];
            }
        }
        else{
            this->rows = 0;
            this->columns = 0;
        }
    }
}

Matice::Matice(const Matice& orig) {
    this->rows = orig.getRows();
    this->rows = orig.getColumns();
    // Vytvoření paměti
    if(rows > 0 && columns > 0){
        this->pointOnPoint = new int*[rows];
        if(this->pointOnPoint != nullptr){
            this->rows = rows;
            this->columns = columns;
            for(int i = 0; i<rows; i++){
                pointOnPoint[i] = new int[columns];
            }
        }
        else{
            this->rows = 0;
            this->columns = 0;
        }
    }
    else{
        this->pointOnPoint = nullptr;
    }
    //Zkopírovaní obsahu paměti
    for(int i = 0; i < this->rows; i++){
        for(int j = 0; j < this->columns; j++){
            this->pointOnPoint[i][j] = orig.getValue(i,j);
        }
    }
}

Matice::~Matice() {
    deletePointerArray();
}

void Matice::deletePointerArray() {
    if(this->pointOnPoint != nullptr){
        for(int i = this->rows;i > 0; i--){
            delete[] this->pointOnPoint[i];
        }
        delete[] this->pointOnPoint;
        this->pointOnPoint = nullptr;
    }
}

void Matice::makePointerArray(){
    
}

int Matice::getValue(int r, int c) const {
    if((r >= 0 && r < this->rows) && (c >= 0 && c < this->columns)){
        return this->pointOnPoint[r][c];
    }
    return -1;
}

int Matice::getRows() const {
    return this->rows;
}

int Matice::getColumns() const {
    return this->columns;
}