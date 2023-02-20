package Observer;

import com.company.Main;

import java.io.*;
import java.net.Socket;

public class Observer extends  Thread implements IObserver{
    Socket connectionsocket;
    BufferedReader infromclient=null;
    DataOutputStream outtoclient=null;
    String clientsentence=null;
    String splitsentence[];

    public Observer(Socket s) {

        connectionsocket=s;
        try {
            this.infromclient = new BufferedReader(new InputStreamReader(this.connectionsocket.getInputStream()));
            this.outtoclient = new DataOutputStream(this.connectionsocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void sendmessage(String message) throws IOException {
        this.outtoclient.writeBytes(message+'\n');
        this.outtoclient.flush();
    }
    public void show_list_to_user() throws IOException {
        String showclient="Stock Count Price"+'\n'+"----------------"+'\n';
        for(int i = 0; i< Main.cs.length; i++) {
            showclient=showclient+Main.cs[i].getname()+"   "+Main.cs[i].getCount()+"   "+Main.cs[i].getprice()+'\n';
        }
        sendmessage(showclient.trim());
    }
    public void run  () {

            try {
                try {
                    show_list_to_user();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                         clientsentence = infromclient.readLine();
                        while (!clientsentence.equalsIgnoreCase("Exit")) {
                            splitsentence = clientsentence.split(" ");
                            if (splitsentence[0].equals("S")) {
                                int temp = Main.name_map.get(splitsentence[1]);
                                Main.cs[temp].subscribe(this);
                                sendmessage("You have successfully subscribed");
                            } else if (splitsentence[0].equals("U")) {
                                int temp = Main.name_map.get(splitsentence[1]);
                                Main.cs[temp].unsubscribe(this);
                                sendmessage("You are unsubscribed");
                            }
                            clientsentence = infromclient.readLine();

                        }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (NullPointerException h) {

                }


    }
}
