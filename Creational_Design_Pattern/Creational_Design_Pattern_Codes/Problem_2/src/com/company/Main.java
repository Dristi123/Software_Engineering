package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        editor edit = editor.geteditor();
        System.out.println("Press 0 to terminate the program");
        while (true) {
        String lang = null;
        String extension = "";
        int flag = 0;
        System.out.println("Enter source file name with extension");
        lang = sc.next();
        if(lang.equalsIgnoreCase("0")) System.exit(0);
        for (int i = 0; i < lang.length(); i++) {
            if (flag == 1) extension = extension + lang.charAt(i);
            if (lang.charAt(i) == '.') {
                flag = 1; //extension=extension+lang.charAt(i+1);
            }
        }
        if(!(extension.equalsIgnoreCase("C")||extension.equalsIgnoreCase("CPP")||extension.equalsIgnoreCase("py")))
        {
            System.out.println("Extension is not valid. Try again");
            continue;
        }
        //System.out.println(extension);

        edit.getinfo(extension);
        //edit.show();
    }
}
}
