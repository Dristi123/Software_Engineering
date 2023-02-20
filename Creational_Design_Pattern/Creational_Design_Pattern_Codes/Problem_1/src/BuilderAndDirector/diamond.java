package BuilderAndDirector;

import Controller.controller;
import Display.display;
import Display.touchscreen;
import Identifier.NFC;
import Identifier.identifier;
import Internet.internetfactory;
import Processor.processor;
import Processor.raspberry;
import Storage.Storage;
import Storage.autoprovided;
import WeighingDevice.load_sensor;
import WeighingDevice.weightmeasurement;
import TeaGas.Device;

public class diamond implements packagebuilder {
    private Device device= new Device();
    public void addprocessor() {

        processor proc=new raspberry();
        device.setProcessor(proc);
    }
    public void measureweight() {

        weightmeasurement weight=new load_sensor();
        device.setWeightmeasurement(weight);
    }
    public void addidentifier() {

        identifier id =new NFC();
        device.setIdentifier(id);
    }
    public void addstorage() {

        Storage st=new autoprovided();
        device.setStorage(st);
    }
    public void adddisplay() {

        display dis=new touchscreen();
        device.setDisplay(dis);
    }
    public void addcontroller() {

        controller cn=new touchscreen();
        device.setController(cn);
    }
    public void addinternet(String internet) {
        internetfactory ifct=new internetfactory();
        Internet.internet it=ifct.getinternet(internet);
        device.setInternet(it);
    }
    public Device getdevice() {
        return device;
    }
}
