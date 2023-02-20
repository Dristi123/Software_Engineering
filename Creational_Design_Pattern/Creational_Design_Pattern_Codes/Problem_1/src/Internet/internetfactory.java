package Internet;

public class internetfactory {
    public internet getinternet(String inter) {
        if(inter.equalsIgnoreCase("WIfi")) return new wifi();
        else if(inter.equalsIgnoreCase("Ethernet")) return new ethernet();
        else if(inter.equalsIgnoreCase("Sim Card")) return new simcard();
        return null;

    }
}
