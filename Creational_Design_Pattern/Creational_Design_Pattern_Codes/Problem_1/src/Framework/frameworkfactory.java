package Framework;

public class frameworkfactory {
    public framework getframework(String name) {
        if(name.equalsIgnoreCase("django")) return new django();
        else if(name.equalsIgnoreCase("spring")) return new spring();
        else if(name.equalsIgnoreCase("laravel")) return new laravel();
        return null;
    }
}
