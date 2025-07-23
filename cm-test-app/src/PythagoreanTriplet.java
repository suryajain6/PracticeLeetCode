import java.util.HashMap;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 6, 5};
        System.out.println(triplets(arr));
    }

    public static int triplets(int [] arr){

        HashMap<Integer, Integer> map= new HashMap<>();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int value = arr[i] * arr[i];
            map.put(value, value);
        }
        for(int i=0;i<arr.length;i++){

            for(int j= i+1;j< arr.length;j++){
                int a = arr[i] * arr[i];
                int b = arr[j] * arr[j];
                int left = a+b;
                if(map.get(left) != null){
                    count = count +1;
                    System.out.println(" a= " + a + " b= "+ b + " c= " + left);
                }
            }

        }


        return count;

    }
}
