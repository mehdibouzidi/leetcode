import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Character> charsMap = new HashMap<>();
        List<Integer> lengths = new ArrayList<>();

        int length=0;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            Character presentChar = charsMap.putIfAbsent(c,c);
            if(presentChar!=null){
                lengths.add(length);
                charsMap = new HashMap<>();
                length=0;
            }else{
                length++;
            }
        }

        return Collections.max(lengths);
    }
}
