package Languagefactory;

import Aesthetics.aesthetics;
import Parser.parser;
import Aesthetics.python_aesthetics;
import Parser.python_parser;

public class python_languagefactory implements languagefactory {
    public aesthetics getaesthetics() {
        return  new python_aesthetics();
    }
    public parser getparser() {
        return  new python_parser();
    }
}
