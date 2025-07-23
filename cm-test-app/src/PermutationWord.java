import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PermutationWord {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> result = new ArrayList<>();
        permuteCombination(str,"",result);
        System.out.println(result);
    }

    private static void permuteCombination(String str, String prefix, List<String> result) {
        if(str.length() == 0){
            result.add(prefix);
          //  System.out.println(result);

        }
        else {
            for(int i=0;i<str.length();i++){
                String currentChar  = String.valueOf(str.charAt(i));
                String remaining = str.substring(0,i) + str.substring(i+1);
                permuteCombination(remaining,prefix+currentChar,result);

            }
        }
    }
}
