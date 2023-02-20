package com.company;

import java.io.IOException;
import java.util.Scanner;

class Admin implements Runnable {
    Scanner sc;
    String line;

    public Admin() {

        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            String[] splitsentence;
            line = sc.nextLine();

            while (!line.equalsIgnoreCase("Exit")) {

                splitsentence = line.split(" ");
                if (splitsentence[0].equals("I")) {
                    //System.out.println("here");
                    int temp = Main.name_map.get(splitsentence[1]);
                    double ammount = Double.parseDouble(splitsentence[2]);
                    try {
                        Main.cs[temp].incprice(ammount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Price of the stock increased");
                } else if (splitsentence[0].equals("D")) {

                    int temp = Main.name_map.get(splitsentence[1]);

                    double ammount = Double.parseDouble(splitsentence[2]);
                    try {

                        Main.cs[temp].decprice(ammount);

                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    System.out.println("Price of the stock decreased");
                } else if (splitsentence[0].equals("C")) {
                    int temp = Main.name_map.get(splitsentence[1]);
                    int ammount = Integer.parseInt(splitsentence[2]);
                    try {
                        Main.cs[temp].changecount(ammount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Count of the stock changed");
                }
                line = sc.nextLine();

            }
            System.exit(0);
        } catch (NullPointerException h) {

        }
    }
}
