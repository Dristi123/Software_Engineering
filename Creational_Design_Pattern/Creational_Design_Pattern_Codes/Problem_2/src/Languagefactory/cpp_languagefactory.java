package Languagefactory;

import Aesthetics.aesthetics;
import Aesthetics.cpp_aesthetics;
import Parser.cpp_parser;
import Parser.parser;

public class cpp_languagefactory implements languagefactory {
    public aesthetics getaesthetics() {
        return  new cpp_aesthetics();
    }
    public parser getparser() {
        return  new cpp_parser();
    }
}
