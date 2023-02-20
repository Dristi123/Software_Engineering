package BuilderAndDirector;

public class packagedirector {
    packagebuilder pb;
    public void construct(packagebuilder packagebuilder,String internet) {
        pb=packagebuilder;
        pb.addprocessor();
        pb.addidentifier();
        pb.addcontroller();
        pb.adddisplay();
        pb.addstorage();
        pb.measureweight();
        pb.addinternet(internet);
    }
}
