package BuilderAndDirector;

import TeaGas.Device;

public interface packagebuilder {
    void addprocessor();
    void measureweight();
    void addidentifier();
    void addstorage();
    void adddisplay();
    void addinternet(String internet);
    void addcontroller();
    Device getdevice();
}
