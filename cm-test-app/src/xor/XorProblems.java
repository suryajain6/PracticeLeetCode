package xor;

import java.util.*;

public class XorProblems {

    public static void main(String [] args){
        beatifulsubArrayCount();
    }

    public static void beatifulsubArrayCount(){
        int[] nums = {2, 3, 5, 4, 5, 3, 4};
        int count = 0;
        int xor =0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int num :nums){
            xor = xor ^ num;
            count = count + map.getOrDefault(xor,0);
            map.put(xor,map.getOrDefault(xor,0) + 1);
        }

        System.out.println("beatifulsubArrayCount: " + count);
    }

    public static List<List<Integer>> findBeautifulSubarrays(int[] nums) {
        Map<Integer, List<Integer>> xorMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        int xor = 0;
        xorMap.put(0, new ArrayList<>(List.of(-1)));  // Handle subarrays starting at index 0

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];

            if (xorMap.containsKey(xor)) {
                for (int start : xorMap.get(xor)) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = start + 1; j <= i; j++) {
                        subarray.add(nums[j]);
                    }
                    result.add(subarray);
                }
            }

            xorMap.computeIfAbsent(xor, k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}
