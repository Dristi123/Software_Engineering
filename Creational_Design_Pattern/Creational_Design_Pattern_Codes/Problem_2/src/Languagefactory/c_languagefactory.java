package Languagefactory;

import Aesthetics.aesthetics;
import Aesthetics.c_aesthetics;
import Parser.c_parser;
import Parser.parser;

public class c_languagefactory implements languagefactory {
    public aesthetics getaesthetics() {
        return  new c_aesthetics();
    }
    public parser getparser() {
        return  new c_parser();
    }
}
