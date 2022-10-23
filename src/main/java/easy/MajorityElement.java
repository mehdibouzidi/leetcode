package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        majorityElement(nums);
    }

    public static int majorityElement(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);
        int maxRepeat = 0;
        int maxEltRepeat = numsList.get(0);
        int repeat = 1;
        int elementRepeat = numsList.get(0);
        for(int i=1; i<numsList.size();i++){
            if(elementRepeat==numsList.get(i)){
                repeat++;
            }else if( elementRepeat!=numsList.get(i)){
                if(maxRepeat<repeat){
                    maxRepeat = repeat;
                    maxEltRepeat = numsList.get(i-1);
                }
                elementRepeat =  numsList.get(i);
                repeat = 1;
            }
            if(i==numsList.size()-1){
                if(maxRepeat<repeat){
                    maxRepeat = repeat;
                    maxEltRepeat = numsList.get(i-1);
                }
            }
        }
        return maxEltRepeat;
    }
}
