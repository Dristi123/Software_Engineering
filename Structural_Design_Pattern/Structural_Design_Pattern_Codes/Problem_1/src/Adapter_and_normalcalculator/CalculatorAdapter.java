package Adapter_and_normalcalculator;

import AdvancedCalculators.AdvancedSumCalculator;
import AdvancedCalculators.Character;

import java.io.IOException;

public class CalculatorAdapter implements SumCalculator {
    AdvancedSumCalculator advancedSumCalculator;
    public void calculateSum(String filename,String type) throws IOException {
        if(type.equalsIgnoreCase("char"))advancedSumCalculator=new Character();
        else return;
        advancedSumCalculator.CalculateChar(filename);
    }
}
