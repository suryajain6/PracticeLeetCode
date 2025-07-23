package LLD.Icecream;

public class MachineIceCream {

public static void main(String [] args){
    GelatoIcecream gelatoIcecream = new GelatoIcecream("Gelato");
    BasicMachine basicMachine = new BasicMachine(gelatoIcecream);
    basicMachine.Serve("Gelato");
}

}
