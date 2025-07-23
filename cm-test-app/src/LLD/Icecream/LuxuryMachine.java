package LLD.Icecream;

public class LuxuryMachine implements Assemble,Makabale,Serve{

    Icecream icecream;

    public LuxuryMachine(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public void make(String iceCreamName) {
        System.out.println("Assemble" + iceCreamName);
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
