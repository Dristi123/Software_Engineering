package Display;

import Controller.controller;

public class touchscreen implements display, controller {
    public String getname() {
        return "Touch Screen";
    }
}
