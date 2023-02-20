package TeaGas;

import BuilderAndDirector.*;

public class TeaGas {
    private webserver wb=null;
    private Device d=null;
    public  void initialize(String packagename,String internet,String frameworkname) {
        packagedirector director = new packagedirector();
        packagebuilder packageb=null;

        if(packagename.equalsIgnoreCase("silver")) {
            packageb = new silver();
        }
        if(packagename.equalsIgnoreCase("gold")) {
             packageb = new gold();
        }
        if(packagename.equalsIgnoreCase("platinum")) {
             packageb = new platinum();
        }
        else if(packagename.equalsIgnoreCase("diamond")) {
            packageb = new diamond();
        }
        director.construct(packageb,internet);
        d=packageb.getdevice();
        d.show();
        wb=new webserver(d,frameworkname);
        wb.showname();
        }
}
