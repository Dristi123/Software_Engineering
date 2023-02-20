package Mediator;


import Mediator.Mediator;
import Organizations.*;

import java.util.HashMap;

public class Concrete_mediator extends Mediator {
    //private HashMap<String,Queue> map;
    private  HashMap<Integer,String> map;
    private JTRC jtrc;
    private JWSA jwsa;
    private JPDC jpdc;
    private JRTA jtra;
    private int count=1;
    public  Concrete_mediator() {
        map=new HashMap<Integer,String>();
    }
    public void init(JRTA jr,JPDC jp,JWSA jw,JTRC jt) {
        this.jpdc=jp;
        this.jtra=jr;
        this.jwsa=jw;
        this.jtrc=jt;
        System.out.println("All four services are initiated through mediator");
    }
    public  void send_service(Organization o) {
        int temp;
        if(o instanceof JPDC) temp=jpdc.remove_from_queue();
        else if(o instanceof  JRTA) temp= jtra.remove_from_queue();
        else if (o instanceof  JWSA) temp= jwsa.remove_from_queue();
        else temp=jtrc.remove_from_queue();
        System.out.println(o.getname()+" serves the request of "+map.get(temp));
    }
    public  void request_service(Organization o, String service) {
         System.out.println(o.getname()+" requests for "+service+" service");
         if(service.equalsIgnoreCase("POWER"))  jpdc.add_in_queue(count);
         else if(service.equalsIgnoreCase("WATER")) jwsa.add_in_queue(count);
         else if(service.equalsIgnoreCase("TRANSPORT")) jtra.add_in_queue(count);
         else jtrc.add_in_queue(count);
         map.put(count,o.getname());
         count++;
    }
}
