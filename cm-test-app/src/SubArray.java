import java.util.List;

public class SubArray {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        int inputArr [] = {1, 4, 20, 3, 10, 5};
        int total = 33;
        sumOfArrayNew(inputArr,total);
    }

    public static void sumOfArray(int []inputArr, int output){
        int sum = 0;
        for(int i=0;i<inputArr.length;i++){
            sum =inputArr[i];
            for(int j=i+1;j<inputArr.length;j++){
                sum = sum + inputArr[j];
                if(sum > output){
                    break;
                }
                if(sum == output){
                    System.out.println( "min is " + ++i +" max is "+ ++j);
                    break;
                }
            }
            if(sum == output){
                break;
            }
        }

    }


    public static void sumOfArrayNew(int []inputArr, int output){
        int sum = 0;
        int min =0;
        for(int i=0;i<inputArr.length;i++){
            sum =sum + inputArr[i];
            if(sum == output){
                System.out.println( "min is " + ++min +" max is "+ ++i);
                break;
            }
            if(sum > output){
                while (sum > output){
                    sum = sum -inputArr[min];
                    min++;
                }
                if(sum == output){
                    System.out.println( "min is " + ++min +" max is "+ ++i);
                    break;
                }

            }

        }

    }


}
