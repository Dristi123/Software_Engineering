package AdvancedCalculators;

import AdvancedCalculators.AdvancedSumCalculator;

import java.io.*;
import java.util.Scanner;

public class Character implements AdvancedSumCalculator {
    public void CalculateChar(String filename) throws IOException {
        FileInputStream fis=new FileInputStream(filename);
        String oldcontent="";
        String newcontent="";
        Scanner sci=new Scanner(fis);
        while (sci.hasNextLine()) {
            oldcontent = oldcontent + sci.nextLine() + System.lineSeparator();

        }
        String [] linetoken=oldcontent.split("\n");
        for(int i=0;i<linetoken.length;i++) {
            String[] tokens=linetoken[i].split(" ");
            for(int j=0;j<tokens.length;j++) {
                int a=(tokens[j].charAt(0));
                newcontent=newcontent+a+" ";
            }
           newcontent=newcontent+"\n" ;
        }
        FileWriter fw=new FileWriter("tempfile.txt");
        fw.write(newcontent);
        fis.close();
        fw.close();
    }
}
