package Observer;

import java.io.IOException;

public interface IObserver {
    public void sendmessage(String message) throws IOException;
}
