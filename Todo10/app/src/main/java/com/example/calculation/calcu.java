package com.example.calculation;

public class calcu{
    public enum Operator{ADD,SUB,MUL,DIV}

    public  double add(double operation1,double operation2){
        return operation1+operation2;
    }


    public  double sub(double operation1,double operation2){
        return operation1-operation2;
    }

    public  double mul(double operation1,double operation2){
        return operation1*operation2;
    }

    public  double div(double operation1,double operation2){
        return operation1/operation2;
    }
}
