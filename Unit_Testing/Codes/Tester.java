package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
    Sorter s;
    public Tester() {
        s=new Sorter();
    }
    boolean test1(ArrayList<Integer> input) {
        //for(int i=0;i<input.size();i++) System.out.println(input.get(i));
        HashMap<Integer,Integer>map=new HashMap<>();
        ArrayList<Integer>output=new ArrayList<>();
        output=s.sort(input);

        //for(int i=0;i<output.size();i++) System.out.println(output.get(i));
        for(int i=0;i<input.size();i++) {
            int count=1;
            if(map.containsKey(input.get(i))){
                count=map.get(input.get(i))+1;
            }
            map.put(input.get(i),count);
        }
        int i;
        for(i=0;i<output.size();i++) {
            if(map.containsKey(output.get(i))) {
                int c=map.get(output.get(i));
                map.put(output.get(i),(c-1));
            }
            else {

                return false;
            }
        }
        if(i==output.size()) {
            for (Integer value: map.values()) {
                if ( value != 0) {
                   return false;
                }
            }
            return true;
        }
    return false;
    }
    boolean test2(ArrayList<Integer> input) {

        ArrayList<Integer>output=new ArrayList<>();
        output=s.sort(input);

        for(int i=0;i<output.size()-1;i++) {
            if(output.get(i)>output.get(i+1)) return false;
        }
        return true;
    }
}
