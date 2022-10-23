import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
//        String s = "";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charsMap = new HashMap<>();
        int length = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer presentIndex = charsMap.putIfAbsent(s.charAt(i), i);
            if (presentIndex != null) {
                maxLength = maxLength<length ? length : maxLength;
                charsMap = charsMap.entrySet().stream()
                        .filter(entry -> entry.getValue()>presentIndex)
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
                charsMap.put(s.charAt(i),i);
                length = charsMap.size();
            } else {
                length++;
                if (i == s.length() - 1) {
                    maxLength = maxLength<length ? length : maxLength;
                }
            }
        }

        return maxLength;
    }
}
