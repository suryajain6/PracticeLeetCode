public class KadanesAlgo {

    public static void main(String[] args) {
        int inputArr [] = {-2,-3,4,-1,-2,1,5,-3};
        maxSubArray(inputArr);
        int arr[] = {3, -4, 2, -3, -1, 7, -5};
        int n = arr.length;

        System.out.print("Smallest sum: "
                + smallestSumSubarr(arr, n));
    }

    public static void maxSubArray(int[] arr){
        int sum =0;
        int start = 0, end =0;
        int maxSum = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum > maxSum){
                maxSum = sum;
                end = i;
            }
            if(sum <0){
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println("Total sum is " + maxSum);
        System.out.println(" Start is " + start + "End is" + end);
    }

    static int smallestSumSubarr(int arr[], int n)
    {

        // to store the minimum value that is
        // ending up to the current index
        int min_ending_here = 2147483647;

        // to store the minimum value encountered
        // so far
        int min_so_far = 2147483647;

        // traverse the array elements
        for (int i = 0; i < n; i++)
        {

            // if min_ending_here > 0, then it could
            // not possibly contribute to the
            // minimum sum further
            if (min_ending_here > 0)
                min_ending_here = arr[i];

                // else add the value arr[i] to
                // min_ending_here
            else
                min_ending_here += arr[i];

            // update min_so_far
            min_so_far = Math.min(min_so_far,
                    min_ending_here);
        }

        // required smallest sum contiguous
        // subarray value
        return min_so_far;
    }
}
