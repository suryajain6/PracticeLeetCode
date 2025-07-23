package LLD.Icecream;

public class BasicMachine implements Serve{

    Icecream icecream;

    public BasicMachine(Icecream icecream){
        this.icecream = icecream;
    }
    @Override
    public void Serve(String iceCreamName) {
        System.out.println("Serve");
    }
}
