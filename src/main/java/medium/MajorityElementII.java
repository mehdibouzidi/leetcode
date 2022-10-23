package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        majorityElement(nums);
    }

    public static List<Integer> majorityElement(int[] nums) {
        int times = (int) ((double) nums.length/ 3);
        List<Integer> allRepeat =  new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);

        int repeat = 1;
        int elementRepeat = numsList.get(0);
        if(nums.length==1){
            allRepeat.add(elementRepeat);
        }
        for(int i=1; i<numsList.size();i++){
            if(elementRepeat==numsList.get(i)){
                repeat++;
            }else if( elementRepeat!=numsList.get(i)){
                if(times<repeat){
                    allRepeat.add(numsList.get(i-1));
                }
                elementRepeat =  numsList.get(i);
                repeat = 1;
            }
            if(i==numsList.size()-1){
                if(times<repeat){
                    allRepeat.add(numsList.get(i));
                }
            }
        }
        return allRepeat;
    }
}
