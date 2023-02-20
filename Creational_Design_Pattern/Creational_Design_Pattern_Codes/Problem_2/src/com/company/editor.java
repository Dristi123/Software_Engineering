package com.company;

import Languagefactory.c_languagefactory;
import Languagefactory.cpp_languagefactory;
import Languagefactory.languagefactory;
import Languagefactory.python_languagefactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class editor {
    private static editor edi = null;
    private Map<String, String> map;
    private languagefactory l=null;
    private editor() {
        map=new HashMap<>();
    }

    public static editor geteditor() {
        if (edi == null) edi = new editor();
        return edi;
    }
    public void getinfo(String source) {

        if (source.equalsIgnoreCase("C")) {
            l= new c_languagefactory();
        }
        else if(source.equalsIgnoreCase("CPP")) {
            l=new cpp_languagefactory();
        }
        else {
            l=new python_languagefactory();
        }
        String x=l.getaesthetics().getfont();
        String y=l.getparser().getname();
        map.put("Parser",y);
        map.put("Font",x);
        show();
    }
    public void show() {
        Set<String> keys=map.keySet();
        for(String eachkey:keys) {
            System.out.println(eachkey+" : "+map.get(eachkey));
        }
    }
}
