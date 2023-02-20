package com.company;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {

    Random rand;
    int MAXINT;
    int maxval;

    public  Generator() {

        rand=new Random();
        MAXINT=1000;
        maxval=0;
    }
    ArrayList<Integer> generateblank() {
        ArrayList<Integer> blank=new ArrayList<>();
        for (int i = 0; i < blank.size(); i++) {
            System.out.println(blank.get(i));
        }
        return blank;

    }
    ArrayList<Integer> generateone() {
        ArrayList<Integer> one=new ArrayList<>();
        int number=rand.nextInt(MAXINT);
        one.add(number);
        return one;
    }
    ArrayList<Integer> generatetwo() {
        ArrayList<Integer> two=new ArrayList<>();

        int number=rand.nextInt(MAXINT);
        two.add(number);
        number=rand.nextInt(MAXINT);
        two.add(number);

        return two;
    }
    ArrayList<Integer> generatesizerandom() {
        ArrayList<Integer> randsize=new ArrayList<>();
        int size=rand.nextInt(1000);
        //System.out.println("sizeee"+size);
        for(int i=0;i<size;i++) {
            int number=rand.nextInt(MAXINT);
            randsize.add(number);
        }

        return randsize;

    }
    ArrayList<Integer> generaterandom() {
        ArrayList<Integer> randnum=new ArrayList<>();
        int number;
        for(int i=0;i<1000;i++) {
            number=rand.nextInt(MAXINT);
            randnum.add(number);
        }

        return randnum;

    }
    ArrayList<Integer> generateasc() {
        ArrayList<Integer> asc=new ArrayList<>();
        int size=rand.nextInt(1000);
        int number;
        int prev=0;

        for(int i=0;i<size;i++){
            number=rand.nextInt(MAXINT)+prev;
            asc.add(number);
            prev=number;

        }
        if(asc.get(size-1)>maxval)maxval=asc.get(size-1);
        //System.out.println(maxval);
        //for(int i=0;i<size;i++) System.out.println(asc.get(i));
        return asc;
    }
    ArrayList<Integer> generatedesc() {
        ArrayList<Integer> desc=new ArrayList<>();
        desc=generateasc();
        Collections.reverse(desc);

        return desc;

    }
    ArrayList<Integer> generateequal() {
        int size=rand.nextInt(1000);
        ArrayList<Integer> equal=new ArrayList<>();
        int number=rand.nextInt(MAXINT);
        for(int i=0;i<size;i++) {
            equal.add(number);
        }

        return equal;
    }
    ArrayList<Integer> generateallneg() {
        int size=rand.nextInt(1000);
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0;i<size;i++) {
            int number=rand.nextInt(MAXINT);
            if(number>0)number=-number;
            neg.add(number);
        }
        return neg;
    }
    ArrayList<Integer> generatedupes() {
        int size=rand.nextInt(1000);
        //System.out.println(size);
        ArrayList<Integer> dupe=new ArrayList<>();

        for(int i=0;i<size/2;i++) {
            int number=rand.nextInt(MAXINT);

            dupe.add(number);
            dupe.add(number);
        }
        if(size%2==1) dupe.add(rand.nextInt());
        return dupe;
    }
    ArrayList<Integer> generateMAX() {
        int size=rand.nextInt(1000);

        ArrayList<Integer> maxvalue=new ArrayList<>();

        for(int i=0;i<size;i++) {
            maxvalue.add(maxval);
        }
        return maxvalue;
    }
    ArrayList<Integer> generateNULL() {
        ArrayList<Integer> nulllist=new ArrayList<>();
        nulllist.add(null);
        return nulllist;
    }

}
