package Organizations;

import Mediator.Mediator;

public class JPDC extends Organization {
    public JPDC(Mediator mediator) {
        super(mediator);
    }
    public void request_service(String service) {
        _mediator.request_service(this,service);
    }
    public void add_in_queue(int i) {
        queue.add(i);
    }
    public int remove_from_queue() {
        return queue.remove();
    }
    public String getname() {
        return  "JPDC";
    }
    public  void send_service() {
        _mediator.send_service(this);
    }
}
