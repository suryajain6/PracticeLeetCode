public class EquilibbriumPoint {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        int arr1 [] = {-7, 1, 5, 2, -4, 3, 0};
        for(int i=0;i<arr1.length;i++){
            int leftsum = 0;
            int rightSum = 0;

            for(int j = 0;j<=i;j++){
                leftsum = leftsum +arr1[j];
            }
            for(int k = i+1;k<=arr1.length;k++){
                rightSum = rightSum +arr1[k];
            }
            if(leftsum == rightSum){
                System.out.println("equ pos is "+ i);
            }
        }

    }
}
