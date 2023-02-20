package Adapter_and_normalcalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IntSumCalculator implements SumCalculator {
    CalculatorAdapter calculatorAdapter;
    public  void calculateSum(String filename,String type) throws IOException {
        if(type.equalsIgnoreCase("int")) {
            System.out.println("The sum of the integers in the file is: "+sum(filename));
        }
        else {
            calculatorAdapter=new CalculatorAdapter();
            calculatorAdapter.calculateSum(filename,type);
            System.out.println("The sum of the ASCII values of the characters in the file is: "+sum("tempfile.txt"));
        }
    }
    public int sum(String filename) throws FileNotFoundException {
        FileInputStream fis=new FileInputStream(filename);
        int sum=0;
        Scanner sci=new Scanner(fis);
        while (sci.hasNextLine()) {
            String[] tokens=sci.nextLine().split(" ");
            for(int i=0;i<tokens.length;i++) {
                sum=sum+Integer.parseInt(tokens[i]);
            }
        }
        return sum;
    }
}
