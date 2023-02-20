package Mediator;

import Organizations.Organization;

public abstract class Mediator {
    public  abstract  void request_service(Organization o, String service);
    public  abstract  void send_service(Organization org);
}
