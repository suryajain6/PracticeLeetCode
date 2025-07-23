import java.util.*;
import java.util.stream.Collectors;

public class WordReverse {

    public static void main(String[] args) {
       String str = "i.like.this.program.very.much";
    // System.out.println(reverseWords(str));
        System.out.println(StringReverse("surya"));
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("a",5);
        map.put("b",3);
        map.put("c",2);

        HashMap<String,Integer> map2 = new HashMap<String, Integer>();
        map2.put("a",4);
        map2.put("b",3);
        map2.put("c",2);
        map2.put("d",1);
        boolean bothEqals = map.entrySet().stream().allMatch(k->map2.containsKey(k.getKey())
                && k.getValue().equals(map2.get(k.getKey())));


        System.out.println(bothEqals);

        String dplicatestr = "Hello";
        List arr = Arrays.asList(dplicatestr.split(""));
        LinkedHashSet set = new LinkedHashSet<>();
        arr.stream().filter(a-> set.add(a)).collect(Collectors.toList());
        System.out.println(String.join("",set));


    }

    public static String reverseWords(String str){
       String[] word =   str.split("\\.");
       for(int i=0,j=word.length-1;i<j ;i++,j--){
           String first = word[i];
           String last = word[j];
           String temp = first;
           word[i] = last;
           word[j] = first;
       }
       str = String.join(".",word);
       return str;

    }

    public static String StringReverse(String str){

        if(str == null || str.length() <=1){
            return str;
        }
            return StringReverse(str.substring(1)) + str.charAt(0);


    }
}
