package com.company;

import java.util.ArrayList;

public class Sorter {
    ArrayList<Integer> sort(ArrayList<Integer> unsortedlist) {
        ArrayList<Integer> ArrList2
                = (ArrayList)unsortedlist.clone();
        for (int i = 0; i < ArrList2.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < ArrList2.size(); j++){
                if (ArrList2.get(j) < ArrList2.get(index)){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = ArrList2.get(index);
            ArrList2.set(index,ArrList2.get(i));
            ArrList2.set(i,smallerNumber);
        }

        return ArrList2;
    }
}
