package testPack;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PractiseAll {

    public static void testsbArrary(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        int target = 12;
        int sum =0;
        boolean found = false;
        for(int i=0;i<arr.size();i++){
            sum = arr.get(i);
            for(int j=i+1;j<arr.size();j++){
                sum = sum + arr.get(j);
                if(sum == target){
                    System.out.println("Found " + j);
                    break;
                } else if (sum > target) {
                    break;
                }
            }
            if(found){
                break;
            }
        }

    }

    public static int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                count++;
            }
        }
        int j=0;
        set.stream().forEach(s->{
            nums[j] = s;
        });
        for(int i=0;i<count;i++){
            System.out.println(nums[i]);
        }
        return count;
    }

    public int removeDuplicates2(int[] nums) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) !=null){
                int count = map.get(nums[i]);
                count ++;
                map.put(nums[i],count);
            }else{
                map.put(nums[i],1);
            }
        }
        int j=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            nums[j] = key;
            j++;
            if(value>1){
                nums[j] = key;
                j++;
            }
        }
        for(int i=0;i<j;i++){
            System.out.println(nums[i]);
        }
        return j;
    }


        public static int maxProfit(int[] prices) {
            int maxNum =0;
            int maxPos =0;
            int buy =prices[0];
            int sell =0;
            int profit =0;

            for(int i=0;i<prices.length;i++){
                if(prices[i] > maxNum){
                    maxNum = prices[i];
                    maxPos = i;
                }
            }

            for(int i=0;i<prices.length;i++){
                if(prices[i] == maxNum){
                    maxNum =0;
                    for(int k=i+1;k<prices.length;k++){
                        if(prices[k] > maxNum){
                            maxNum = prices[k];
                            maxPos = k;
                        }
                    }
                    continue;
                }

                if(prices[i] <buy){
                    buy = prices[i];
                }


                for(int j=i+1;j<=maxPos;j++){
                    if(buy < prices[j]){
                        sell = prices[j];
                        if(profit < (sell-buy)){
                            profit = sell-buy;
                            System.out.println(profit);
                        }
                    }
                }


            }
            return profit;
        }

        public static int jump(int[] nums) {
        //23114
            if(nums.length <= 1) return 0;
            int jumps=0;
            int farthest = 0;
            int currEnd =0;
            for(int i=0;i<nums.length-1;i++){
                farthest = Math.max(farthest, i+nums[i]);
                if(i==currEnd){
                    jumps++;
                    currEnd = farthest;
                    if(currEnd >= nums.length -1) break;
                }
            }
            return jumps;
        }

    public static List<List<String>> groupAnagrams2(String[] strs){

        HashMap<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char [] chs = str.toCharArray();
            Arrays.sort(chs);
            String temp = new String(chs);
            if(map.get(temp) != null){
                List<String> lists = map.get(temp);
                lists.add(str);
                map.put(temp,lists);
            }else {
                List<String> lists = new ArrayList<>();
                lists.add(str);
                map.put(temp,lists);
            }
        }
        System.out.println(new ArrayList<>(map.values()));
        return new ArrayList<>(map.values());

    }

    public static int findKthLargest(int[] nums, int k) {
       //nums = [3,2,1,5,6,4], k = 2
       /* Arrays.sort(nums);
        int pos = nums.length - k;*/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        System.out.println(queue.peek());
        return queue.peek();
    }

    public boolean isSubsequence(String s, String t) {
       return true;
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length ==0) return -1;
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int count =0;
        int rem =0;
        int quotient = amount;
        int n = coins.length;
        for(int i=n-1;i>=0;i--){

            if(quotient/coins[i] > 0){
                int coinCount = quotient/coins[i];
                quotient = quotient%coins[i];
                count = count + coinCount;
            }

        }
        if(count == 0){
            return -1;
        }
        return count;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int mid =  n/2;
        if(citations[mid] >= mid){
            return mid;
        }else{
            return 0;
        }


    }

    public static String reverseWords(String s) {
        s = s.trim();
        List<String> list = List.of(s.split("\\s+"));
        StringBuilder sb = new StringBuilder();
        Stack stk = new Stack();
        for(String l : list){
            stk.push(l);
        }
        while (!stk.isEmpty()){
            if(!stk.peek().equals(" ")){
                sb.append(stk.pop()).append(" ");
            }

        }
        System.out.println(sb.toString().trim());
        return sb.toString().trim();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int maxLength = 0;
        int sum =0;
        int k=0;
        int minLen =0;
        int currLen =0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            currLen++;
            if(sum == target){
                if(minLen ==0 || minLen > currLen){
                    minLen = currLen;
                }

            }else if(sum > target){
                while(sum > target){
                    sum = sum - nums[k];
                    k++;
                    currLen--;
                }
                if(sum == target){
                    if(minLen ==0 || minLen > currLen){
                        minLen = currLen;
                    }

                }
            }
        }

        return minLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            String currChar = String.valueOf(s.charAt(i));
            if(temp.indexOf(currChar) > -1){
                int delIndex = temp.indexOf(currChar);
                temp = new StringBuilder(temp.substring(delIndex + 1));
                temp.append(currChar);
            }else{
                temp = temp.append(currChar);
                maxLength = Math.max(maxLength,temp.length());
            }

        }
        System.out.println(maxLength);
        return maxLength;
    }

    //Input: s = "barfoothefoobarman", words = ["foo","bar"]
    public static List<Integer> findSubstring(String s, String[] words) {
       String temp = "";
       List<Integer> count = new ArrayList<>();
       int startIndex =-1;
       int len = words[0].length();
        for(int i=0;i<s.length();i++){
            temp = temp +s.charAt(i);
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0;j< words.length;j++){
                if(temp.contains(words[j])){
                    int index = s.indexOf(words[j]);
                    map.put(words[j],index);
                }
            }
            if(map.size() == words.length){

                for(Map.Entry<String,Integer> m: map.entrySet()){
                    if(startIndex == -1){
                        startIndex = m.getValue();
                    }else{
                        startIndex = Math.min(startIndex,m.getValue());
                    }
                }
                count.add(startIndex);
                temp = temp.substring(startIndex + len);
                startIndex = -1;
            }
        }
        System.out.println(count);
        return count;
    }

    public boolean isIsomorphic(String s, String t) {
        boolean isIso = false;
        List<String> sStr = List.of(s.split(""));
        List<String> tStr = List.of(t.split(""));
        List<Long> sList = sStr.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).values().stream().sorted().collect(Collectors.toList());
        List<Long> tList = tStr.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).values().stream().sorted().collect(Collectors.toList());
        if(s.length() == t.length()){
            isIso =  IntStream.range(0,sList.size()).allMatch(i->sList.get(i).equals(tList.get(i)));
        }
        return isIso;
    }

    public static boolean wordPattern(String pattern, String s) {
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        LinkedHashMap<String,String> map2 = new LinkedHashMap<>();
        List<String> patternList = List.of(pattern.split(""));
        patternList = patternList.stream().sorted().collect(Collectors.toList());
        List<String> sList = List.of(s.split("\\s+"));
        sList = sList.stream().sorted().collect(Collectors.toList());
        if(patternList.size() != sList.size()){
            return false;
        }else{
            for(int i=0;i<patternList.size();i++){
                if((map.get(patternList.get(i)) != null && map2.get(sList.get(i)) == null)
                || (map2.get(sList.get(i)) != null && map.get(patternList.get(i)) == null)
                ){
                    return false;
                }
                if(map.get(patternList.get(i)) != null && map2.get(sList.get(i)) != null){
                    String sListValue = map.get(patternList.get(i));
                    String pListValue = map2.get(sList.get(i));
                    if(!sListValue.equalsIgnoreCase(sList.get(i)) && !pListValue.equalsIgnoreCase(patternList.get(i))){
                        return false;
                    }
                }else{
                    map.put(patternList.get(i),sList.get(i));
                    map2.put(sList.get(i),patternList.get(i));
                }
            }
        }



        return true;
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<String,Integer> map1 = new HashMap<String,Integer>();
        HashMap<String,Integer> map2 = new HashMap<String,Integer>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            String l = String.valueOf(s.charAt(i));

            if(map1.get(l) != null){
               Integer count =  map1.get(l);
               count++;
               map1.put(l,count);
            }else{
                map1.put(l,1);
            }

        }
        for(int i=0;i<t.length();i++){
            String l = String.valueOf(t.charAt(i));
            if(map2.get(l) != null){
                Integer count =  map2.get(l);
                count++;
                map2.put(l,count);
            }else{
                map2.put(l,1);
            }

        }

        for(Map.Entry<String,Integer> m : map1.entrySet()){
            String k = m.getKey();
            Integer val = m.getValue();
            if(val != map2.get(k)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str :strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(map.get(sortedStr) != null){
                List<String> list = map.get(sortedStr);
                list.add(str);
                map.put(sortedStr,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static int longestConsecutive(int[] nums) {
        int count =1;
        Arrays.sort(nums);
        int maxCount =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] ==1){
                maxCount ++;
            }
            else{
                count = Math.max(maxCount,count);
                maxCount =1;
            }
        }
        count = Math.max(maxCount,count);
        return count;
    }

    public int[] twoSum(int[] nums, int target) {

        List<Integer> lists = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(lists);
        int[] twoSum = new int[2];
        for(int i=0;i<lists.size();i++){
            int j=i+1;
            while(nums[i] + nums[j] <= target){
                if(nums[i] + nums[j] == target){
                    twoSum[0] = i;
                    twoSum[1] = j;
                    return twoSum;
                }
                j++;
            }

        }
        return twoSum;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + left + right;
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],left,right));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum<0) {
                    left ++;
                }else{
                    right --;
                }
            }

        }
        return result;
    }

    public boolean isValid(String s) {
        Stack stk = new Stack();
        char[] charArr =   s.toCharArray();
        for(int i=0;i<s.length();i++){
          char c =  charArr[i];
          if(c == '(' || c== '{' || c== '['){
              stk.push(c);
          }else{
              char top = (char) stk.pop();
              if(c == ')' && top != '('){
                  return false;
              }
              if(c == '}' && top != '{'){
                  return false;
              }
              if(c == ']' && top != '['){
                  return false;
              }
          }
        }
        return true;

    }

    public boolean hasCycle(ListNode head) {

        ListNode current = head;
        HashSet<ListNode> set = new HashSet<>();
        while(current != null){
            if(!set.add(current)){
                return false;
            }else{
                set.add(current);
            }
        }
        return true;
    }

    public static int minSubArrayLen2(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == target){
                return 1;
            }
            int sum =nums[i];
            int j=i+1;
            while(sum <= target && j<nums.length-1){
                sum = sum  + nums[j];
                if(sum == target){
                    min = Math.min(min,j-i+1);
                    break;
                }
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    public boolean jumpGame(int [] nums){

        int jump =0;
        for(int i=0;i<nums.length;i++){
            if(i>jump){
                return false;
            }
            jump = Math.max(jump,i+nums[i]);
            if(jump>=nums.length){
                return true;
            }
        }
        return true;
    }


    public static int[] freq(int[] arr, int k){
        int [] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]) != null){
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i],count);
            }else{
                map.put(arr[i],1);
            }
        }

        List<Integer> result = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()))
                .map(m->m.getKey()).collect(Collectors.toList());
        System.out.println(result);
        return res;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        List numsList = Arrays.asList(nums);
        map = (HashMap<Integer, Integer>) numsList.stream().collect(Collectors.groupingBy(m->m,Collectors.counting()));
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            int cal = n/2;
            if(m.getValue() > cal){
                return m.getKey();
            }
        }

        return 0;
    }

    public static void main(String [] args){

        //testsbArrary();
       /* int []nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);*/

        /*int[] prices = {7,1,5,3,6,4};
        maxProfit(prices);*/

       /* int[] nums = {2,3,1,1,4};
        jump(nums);*/

       /* int[] citations = {3,0,6,1,5};
        hIndex(citations);*/

      /*  String s= "the sky is blue";
        reverseWords(s);*/

        /*int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7,nums);*/

        /*String s = "aab";
        lengthOfLongestSubstring(s);*/

       /* String s = "barfoothefoobarman";
        String [] words = {"foo","bar"};
        findSubstring(s,words);*/

        /*String pattern = "abba";
        String s = "dog cat cat fish";
        wordPattern(pattern,s);*/

        /*int [] nums = {0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(nums);*/

      /*  int[] nums = {2,3,1,2,4,3};
        minSubArrayLen2(7,nums);*/

      /*  int[] nums = {1,1,3,2,3,3,3,2,1,1,1,3,3};
       freq(nums,2);*/

      /* int [] coins = {1,2,5};
        coinChange(coins,11);*/

      /*  String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams2(strs);*/

        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        findKthLargest(nums,k);
    }
}

class ListNode {
     int val;
      ListNode next;
     ListNode(int x) {
        val = x;
         next = null;
    }
 }
