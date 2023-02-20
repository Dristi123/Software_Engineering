package TeaGas;


import Controller.controller;
import Display.display;
import Identifier.identifier;
import Internet.internet;
import Processor.processor;
import Storage.Storage;
import WeighingDevice.weightmeasurement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Device {
    private Map<String, String > map;
    private Processor.processor processor=null;
    private WeighingDevice.weightmeasurement weightmeasurement=null;
    private Identifier.identifier identifier=null;
    private Storage storage=null;
    private display display=null;
    private Internet.internet internet=null;
    private Controller.controller controller=null;
    public Device() {
        map=new HashMap<>();
    }

    public void setProcessor(processor processor) {
        this.processor = processor;
        Add("Processor",processor.getname());
    }

    public void setWeightmeasurement(weightmeasurement weightmeasurement) {
        this.weightmeasurement = weightmeasurement;
        Add("WeightMeasurement",weightmeasurement.getname());
    }

    public void setIdentifier(identifier identifier) {
        this.identifier = identifier;
        Add("Identifier",identifier.getname());
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
        Add("Storage",storage.getname());
    }

    public void setDisplay(Display.display display) {
        this.display = display;
        Add("Display",display.getname());
    }

    public void setInternet(internet internet) {
        this.internet = internet;
        if(internet==null) Add("Internet","This module is not compitabe with the package");
        else Add("Internet",internet.getname());
    }

    public void setController(controller controller) {
        this.controller = controller;
        Add("Controller",controller.getname());
    }


    public void Add(String component,String  name) {
        map.put(component,name);
    }
    public void show() {
        Set<String> keys=map.keySet();
        for(String eachkey:keys) {
            System.out.println(eachkey+" : "+map.get(eachkey));
        }
    }
}
