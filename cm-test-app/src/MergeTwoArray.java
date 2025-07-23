import java.util.Arrays;

public class MergeTwoArray {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        int arr1 [] = {1,3,5,7};
        int arr2 [] = {0,2,6,8,9};
        mergeTwoArray(arr1,arr2);

    }

    public static void mergeTwoArray(int []arr1, int [] arr2){
        // find min

       int n = arr1.length;
       int m = arr2.length;
       int i = 0;
       int j= 0;
       int k = n -1;
       while (i< k && j<m){

           if(arr1[i]<arr2[j]){
               i++;
           }else{
               int temp = arr2[j];
               arr2[j] = arr1[k];
               arr1[k] = temp;
               j++;
               k--;
           }
       }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }
}
