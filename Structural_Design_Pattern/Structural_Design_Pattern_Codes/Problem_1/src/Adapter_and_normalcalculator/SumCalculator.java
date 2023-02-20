package Adapter_and_normalcalculator;

import java.io.File;
import java.io.IOException;

public interface SumCalculator {
    public void calculateSum(String filename,String type) throws IOException;
}
