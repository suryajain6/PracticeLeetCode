public class LeaderInArray {

    public static void main(String[] args) {
        int inputArr [] = {16,17,4,3,5,2};
        int n= inputArr.length;
        int max = inputArr[n-1];
        for(int i=n-1;i>=0;i-- ){
            if(inputArr[i] > max){
                max = inputArr[i];
            }
        }
        System.out.println("max is " + max);

    }
}
