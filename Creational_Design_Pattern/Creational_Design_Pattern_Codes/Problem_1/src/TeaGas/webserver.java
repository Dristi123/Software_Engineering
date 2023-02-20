package TeaGas;

import Framework.framework;
import Framework.frameworkfactory;

class webserver {
    private framework fm=null;
    private Device madedevice=null;
    //public  framework getframework();
    webserver(Device d, String framename) {
        frameworkfactory fmfct=new frameworkfactory();
        fm=fmfct.getframework(framename);
        madedevice=d;
    }
    void showname() {
        System.out.println("Webserver with "+fm.getname()+" framework created");
    }
}
