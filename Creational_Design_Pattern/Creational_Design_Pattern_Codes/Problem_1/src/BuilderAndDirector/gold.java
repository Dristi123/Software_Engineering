package BuilderAndDirector;

import Controller.button;
import Controller.controller;
import Display.LED;
import Display.display;
import Identifier.RFID;
import Identifier.identifier;
import Internet.internetfactory;
import Processor.arduino;
import Processor.processor;
import Storage.Storage;
import Storage.SD;
import WeighingDevice.weight_module;
import WeighingDevice.weightmeasurement;
import TeaGas.Device;

public class gold implements packagebuilder {
    private Device device= new Device();
    public void addprocessor() {
        processor proc=new arduino();
        device.setProcessor(proc);
    }
    public void measureweight() {
        weightmeasurement weight=new weight_module();
        device.setWeightmeasurement(weight);
    }
    public void addidentifier() {
        identifier id =new RFID();
        device.setIdentifier(id);
    }
    public void addstorage() {
        Storage st=new SD();
        device.setStorage(st);
    }
    public void adddisplay() {
        display dis=new LED();
        device.setDisplay(dis);
    }
    public void addcontroller() {
        controller cn=new button();
        device.setController(cn);
    }
    public void addinternet(String internet) {
        if (internet.equalsIgnoreCase("Ethernet")) device.setInternet(null);
        else {
            internetfactory ifct = new internetfactory();
            Internet.internet it = ifct.getinternet(internet);
            device.setInternet(it);
        }
    }
    public Device getdevice() {
        return device;
    }
}