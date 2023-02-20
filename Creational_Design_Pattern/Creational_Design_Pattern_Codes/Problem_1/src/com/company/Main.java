package com.company;

import TeaGas.TeaGas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String[] packagename = {"silver", "gold", "diamond", "platinum"};
        String[] internetname = {"WiFi", "Sim Card", "Ethernet"};
        String[] framename = {"Django", "Spring", "Laravel"};
        System.out.println("Press 0 to exit system");
        while (true) {
            TeaGas tg = new TeaGas();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose Package");
            System.out.println("1.Silver 2.Gold 3.Diamond 4.Platinum");
            int a = scanner.nextInt();
            if(a==0) System.exit(0);
            System.out.println("Choose Internet connection");
            System.out.println("1.WiFi 2.Sim Card 3.Ethernet");
            int b = scanner.nextInt();
            if(b==0) System.exit(0);
            System.out.println("Choose framework for the webserver");
            System.out.println("1.Django 2.Spring 3.Lavarel");
            int c = scanner.nextInt();
            if(c==0) System.exit(0);
            tg.initialize(packagename[a - 1], internetname[b - 1], framename[c - 1]);
        }
    }
}
