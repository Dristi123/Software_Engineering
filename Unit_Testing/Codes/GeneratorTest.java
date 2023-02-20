package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GeneratorTest {
    private  Tester t;
    private  Generator generator;
    @BeforeAll
    void init() {
        t = new Tester();
        generator=new Generator();
    }
    @Test
    void testblank() {
        ArrayList<Integer> blank=generator.generateblank();
        Assertions.assertTrue(t.test1(blank),"In testblank sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(blank),"In testblank sorted list's "+"Order is wrong!!");
    }

    @Test
    void testeone() {
        ArrayList<Integer> one=generator.generateone();
        Assertions.assertTrue(t.test1(one),"In testone sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(one),"In testone sorted list's "+"Order is wrong!!");
    }

    @Test
    void testtwo() {
        ArrayList<Integer> two=generator.generatetwo();
        Assertions.assertTrue(t.test1(two),"In testtwo sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(two),"In testtwo sorted list's "+"Order is wrong!!");
    }

    @Test
    void testsizerandom() {
        ArrayList<Integer> sizerand=generator.generatesizerandom();
        Assertions.assertTrue(t.test1(sizerand),"In testsizerandom sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(sizerand),"In testsizerandom sorted list's "+"Order is wrong!!");
    }

    @Test
    void testrandom() {
        ArrayList<Integer> random=generator.generaterandom();
        Assertions.assertTrue(t.test1(random),"In testrandom sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(random),"In testrandom sorted list's "+"Order is wrong!!");
    }

    @Test
    void testasc() {
        ArrayList<Integer> asc=generator.generateasc();
        Assertions.assertTrue(t.test1(asc),"In testasc sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(asc),"In testasc sorted list's "+"Order is wrong!!");
    }

    @Test
    void testdesc() {
        ArrayList<Integer> desc=generator.generatedesc();
        Assertions.assertTrue(t.test1(desc),"In testdesc sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(desc),"In testdesc sorted list's "+"Order is wrong!!");
    }

    @Test
    void testequal() {
        ArrayList<Integer> eq=generator.generateequal();
        Assertions.assertTrue(t.test1(eq),"In testequal sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(eq),"In testequal sorted list's "+"Order is wrong!!");
    }
    @Test
    void testneg() {
        ArrayList<Integer> neg=generator.generateallneg();
        Assertions.assertTrue(t.test1(neg),"In testneg sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(neg),"In testneg sorted list's "+"Order is wrong!!");
    }
    @Test
    void testdupe() {
        ArrayList<Integer> dup=generator.generatedupes();
        Assertions.assertTrue(t.test1(dup),"In testdupe sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(dup),"In testdupe sorted list's "+"Order is wrong!!");
    }
    @Test
    void testmax() {
        ArrayList<Integer> max=generator.generateMAX();
        Assertions.assertTrue(t.test1(max),"In testmax sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(max),"In testmax sorted list's "+"Order is wrong!!");
    }
    @Test
    void testnull() {
        ArrayList<Integer> nullist=generator.generateNULL();
        Assertions.assertTrue(t.test1(nullist),"In testnull sorted list "+"Doesnot have the same numbers!!");
        Assertions.assertTrue(t.test2(nullist),"In testnull sorted list's "+"Order is wrong!!");
    }
}