package medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs).stream().forEach(System.out::println);
    }
    public  static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> strsMap = new HashMap<>();

        for(int i=0; i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String ordredWord = new String(chars);
            List<String> anagrams = strsMap.get(ordredWord);
            if(anagrams==null || anagrams.size()==0){
                anagrams = new ArrayList<>();
            }
            anagrams.add(strs[i]);
            strsMap.put(ordredWord, anagrams);
        }

        return new ArrayList<>(strsMap.values());
    }
}
