package Organizations;

import Mediator.Mediator;

public class JRTA extends Organization {

    public JRTA(Mediator mediator) {
        super(mediator);
    }
    public String getname() {
        return  "JRTA";
    }
    public void add_in_queue(int i) {
        queue.add(i);
    }
    public int remove_from_queue() {
        return queue.remove();
    }
    public void request_service(String service) {
        _mediator.request_service(this,service);
    }
    public  void send_service() {
        _mediator.send_service(this);
    }
}
