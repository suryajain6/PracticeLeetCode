package LLD.Icecream;

public class PremiumMachine implements Serve,Assemble{

    Icecream icecream;

    public PremiumMachine(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public void assemble(String iceCream) {
        System.out.println("Assemble" + iceCream);
    }

    @Override
    public void Serve(String iceCreamName) {
        System.out.println("Serve" + iceCreamName);
    }
}
