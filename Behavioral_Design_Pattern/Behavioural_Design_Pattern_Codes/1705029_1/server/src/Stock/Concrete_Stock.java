package Stock;

import Observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Concrete_Stock implements Stock {
    private  double price;
    private  int count;
    private String name;
    List<Observer> listofobservers=new ArrayList<Observer>();
    public void setprice(double p) {
        price=p;
    }
    public void setName(String name1) {
        this.name=name1;
    }
    public String getname() {
        return  name;
    }
    public  void setcount(int c) {
        count=c;
    }
    public int getCount() {
        return  count;
    }
    public double getprice() {

        return price;
    }
    public void incprice(double value) throws IOException {

        this.price=this.price+value;
        notifyobservers("price",this.price);

    }
    public void decprice(double value) throws IOException {

        this.price=this.price-value;
        notifyobservers("Price",this.price);
    }
    public void changecount(int counti) throws IOException {

        this.count=counti;
         notifyobservers("Count",this.count);
    }
    public void subscribe(Observer tc) throws IOException {
        listofobservers.add(tc);
    }
    public void unsubscribe(Observer tc) {
        listofobservers.remove(tc);
    }
    public void notifyobservers(String operation,double val) throws IOException {
        for(int i=0;i<listofobservers.size();i++) {
            listofobservers.get(i).sendmessage("Your subscribed Stock "+name+"'s "+operation+" changed to "+ val);
        }
    }

}
