public class TestConstructor {

    public String a1 = "a1";
    public String a2 = "a2";
    public String a3 = "a3";

    public TestConstructor(){

    }
    private TestConstructor(String a1){
        this.a1 = a1;
    }
    public TestConstructor(String a1, String a2){
        this.a1 = a1;
        this.a2 = a2;

    }
    public void testmethod1(){

    }
    public void testmethod2(){

    }
}

 class SubClass extends TestConstructor{

    private String b1 ="b1";
    public String b2 = "b2";
    public String a3 = "suba3";
     public SubClass(){
     }
     public SubClass(String a1){
     }

     public void testmethod2(){

     }
     public void testmethod3(){

     }

     public static void main(String [] args){
         TestConstructor testConstructor = new SubClass();
         ((SubClass)testConstructor).testmethod3();
         System.out.println(testConstructor.a3);

         SubClass subClass = (SubClass) testConstructor;
         subClass.testmethod1();
         System.out.println(subClass.a3);

     }
}