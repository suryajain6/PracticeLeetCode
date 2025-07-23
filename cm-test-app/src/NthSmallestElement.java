import java.util.PriorityQueue;

public class NthSmallestElement {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        System.out.println("Smallest element is " +smallestElement(arr, 4));
        System.out.println("Smallest element is " +largestElement(arr, 4));

    }

    public static int smallestElement(int [] arr, int n){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size() > n){
                pq.remove();
            }
        }
        return pq.peek();

    }

    public static int largestElement(int [] arr, int n){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size() > n){
                pq.remove();
            }
        }
        return pq.peek();

    }
}
