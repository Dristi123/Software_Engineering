package com.company;

import Adapter_and_normalcalculator.IntSumCalculator;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int choice;
        IntSumCalculator intSumCalculator =new IntSumCalculator();
        System.out.println("What type of file it is?");
        System.out.println("1.Integer 2.Character");
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        if(choice==1) intSumCalculator.calculateSum("input.txt","int");
        else intSumCalculator.calculateSum("input.txt","char");
        // write your code here
    }
}
