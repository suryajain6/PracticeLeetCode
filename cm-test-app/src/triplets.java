import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class triplets {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        int inputArr [] = {1, 2, 3, 4, 5};
        int total = 33;
      //  countTripletsNew(inputArr);
        int inputArr2 [] = {1, 2, 3, 5};
        int n = 5;
        System.out.println(missingNumbers(inputArr2,n));
    }

    public static int missingNumbers(int inputArr [], int n){
        IntStream arr =Arrays.stream(inputArr);
        int sum =arr.sum();
        int total = (n*(n+1))/2;
        return total-sum;
    }

    public static int countTripletsNew(int inputArr []){
        HashMap map = new HashMap<>();
        for (int i=0;i<inputArr.length;i++){
            map.put(inputArr[i],1);
        }
        int count = 0;
        for(int i=0;i<inputArr.length ; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                int sum = inputArr[i] + inputArr[j];
                if(map.get(sum) != null){
                    count = count +1;
                    System.out.println(" pair is (" + inputArr[i] + ","+ inputArr[j]+", "+sum +")");
                }
            }
        }
        return count;

    }

    public static int countTriplets(int inputArr []){
        int count =0;
        for(int i=0;i<inputArr.length ; i++){
            for(int j =i+1;j<inputArr.length; j++){
                int sum = inputArr[i] + inputArr[j];
                for(int k = 0;k<inputArr.length;k++){
                    if(sum == inputArr[k]){
                        count = count +1;
                        System.out.println(" pair is (" + inputArr[i] + ","+ inputArr[j]+", "+inputArr[k]);
                        break;
                    }
                }
            }
        }


        return count;
    }
}
