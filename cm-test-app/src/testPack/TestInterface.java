package testPack;

public interface TestInterface {

    public static final int varX = 12;

    default void display()
    {
        System.out.println("hello");
    }

    static void displayX()
    {
        System.out.println("helloX");
    }

}

class TestClass implements TestInterface
{
    // Driver Code
    public static void main (String[] args)
    {
        TestClass t = new TestClass();
        t.display();
        TestInterface.displayX();
    }
}
