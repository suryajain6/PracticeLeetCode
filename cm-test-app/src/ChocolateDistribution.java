import java.util.PriorityQueue;

public class ChocolateDistribution {

    public static void main(String[] args) {

    }

    public static int distribution(int [] arr, int m){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        for(int i=0;i<arr.length;i++ ){

            pq.add(arr[i]);
            if(pq.size() > m){
                pq.remove(arr[i]);
            }
        }
        Integer[] arr2 = (Integer[]) pq.toArray();
        return arr2[m-1] - arr2[0];
    }



}
