package com.company;

import Mediator.Concrete_mediator;
import Organizations.JPDC;
import Organizations.JRTA;
import Organizations.JTRC;
import Organizations.JWSA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Concrete_mediator cm=new Concrete_mediator();
        //cm.send_service();
        JPDC jpdc=new JPDC(cm);
        JTRC jtrc=new JTRC(cm);
        JWSA jwsa=new JWSA(cm);
        JRTA jrta=new JRTA(cm);

        Scanner sc=new Scanner(System.in);
        while (true) {
            String input=sc.nextLine();
            String arr[]=input.split(" ");
            if(arr[0].equalsIgnoreCase("INIT")) cm.init(jrta,jpdc,jwsa,jtrc);
            else if(arr[0].equalsIgnoreCase("EXIT")) System.exit(0);
            else if(arr[1].equalsIgnoreCase("SERVE")) {
                if(arr[0].equalsIgnoreCase("JPDC"))jpdc.send_service();
                else if(arr[0].equalsIgnoreCase("JWSA"))jwsa.send_service();
                else if (arr[0].equalsIgnoreCase("JRTA"))jrta.send_service();
                else jtrc.send_service();
            }
            else {
                if(arr[0].equalsIgnoreCase("JPDC"))jpdc.request_service(arr[1]);
                else if(arr[0].equalsIgnoreCase("JWSA"))jwsa.request_service(arr[1]);
                else if (arr[0].equalsIgnoreCase("JRTA"))jrta.request_service(arr[1]);
                else jtrc.request_service(arr[1]);
            }

        }

        //jpdc.send_service();
        //jpdc.send_service();
    }

}
