package com.company;

import Stock.Concrete_Stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Main {
    public static Concrete_Stock[] cs;
    public static HashMap<String,Integer> name_map;
    public static void main(String[] args) throws IOException {
        System.out.println("Server Started");
        System.out.println("Type \"Exit\" to quit");
        String clientsentence=null;
        String count_array="";
        String price_array="";
        String name_array="";
        ServerSocket ws=new ServerSocket(6666);
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        int id=1;
        int count=0;
        String[] splits;
        String line=null;
        while ((line=br.readLine())!=null) {
            splits=line.split(" ");
            name_array=name_array+splits[0]+" ";
            count_array=count_array+splits[1]+" ";
            price_array=price_array+splits[2]+" ";
            count++;

        }
        cs=new Concrete_Stock[count];
        name_map=new HashMap<String,Integer>();
        for(int i=0;i<count;i++) {
            cs[i]=new Concrete_Stock();
            cs[i].setName(name_array.split(" ")[i]);
            name_map.put(cs[i].getname(),i);
            cs[i].setcount(Integer.parseInt(count_array.split(" ")[i]));
            cs[i].setprice(Double.parseDouble(price_array.split(" ")[i]));
        }
        //System.out.println();
        connection_thread ct=new connection_thread(ws);
        Admin it=new Admin();
        Thread ts=new Thread(ct);
        ts.start();
        Thread tr=new Thread(it);
        tr.start();
    }
}

