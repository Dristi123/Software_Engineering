package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Generator g=new Generator();
        Tester t=new Tester();
        System.out.println(t.test1(g.generateasc()));
        System.out.println(t.test2(g.generateasc()));
    }
}
