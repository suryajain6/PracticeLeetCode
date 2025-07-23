public class NumberOfPairs {

    public static void main(String[] args) {
        int arr1 [] = {2,3,4,5};
        int arr2 [] = {1,2,3};
        pairs(arr1,arr2);
    }

    public static void pairs(int [] arr1, int [] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int countPairs =0;
        for(int i=0;i<m;i++){
            for(int j= 0;j<n;j++){
                double xpowY = Math.pow(arr1[i],arr2[j]);
                double ypowX = Math.pow(arr2[j],arr1[i]);
                if(xpowY > ypowX){
                    countPairs = countPairs + 1;
                }
            }
        }
        System.out.println("Count pairs " + countPairs);
    }
}
