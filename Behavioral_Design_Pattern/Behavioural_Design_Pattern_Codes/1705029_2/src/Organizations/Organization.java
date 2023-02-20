package Organizations;


import Mediator.Mediator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Organization {
    protected Mediator _mediator;
    public  Organization(Mediator m) {
        _mediator=m;
        queue=new LinkedList<Integer>();
    }
    public abstract String getname() ;
    protected Queue<Integer> queue;
}
