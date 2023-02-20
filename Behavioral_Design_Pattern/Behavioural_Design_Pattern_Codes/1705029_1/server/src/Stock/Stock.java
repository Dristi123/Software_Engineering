package Stock;

import Observer.Observer;

import java.io.IOException;

public interface Stock {
    void subscribe(Observer tc) throws IOException;
    void unsubscribe(Observer tc);
    void notifyobservers(String op,double i) throws IOException;
}
