import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}};
//        result: [[0,2],[2,6]]
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> intervalsList = Arrays.asList(intervals);
        intervalsList.sort((inter1,inter2)->
                (inter1[0]<inter2[0]) ? -1 : (inter1[0]>inter2[0]) ? 1 : inter1[1]<inter2[1] ? -1 : inter1[1]>inter2[1] ? 1 : 1);

        intervalsList.forEach(inter -> System.out.print(inter[0]+","+inter[1]+"     /     "));
        System.out.println();
        System.out.println();

        List<int[]> toMerge = new ArrayList<>();
        toMerge.add(intervals[0]);

        for(int i=0;i<intervals.length;i++){
            toMerge.forEach(inter -> System.out.print(inter[0]+","+inter[1]+"     /     "));
            System.out.println();
            int[] currentInterval = toMerge.get(toMerge.size()-1);
            if(currentInterval[1]<intervals[i][0]){
                toMerge.add(intervals[i]);
            }else{
                int max = (currentInterval[1]>intervals[i][1]) ? currentInterval[1] : intervals[i][1];
                int min = (currentInterval[0]<intervals[i][0]) ? currentInterval[0] : intervals[i][0];
                toMerge.set(toMerge.size()-1,new int[]{min,max});
            }
        }
        System.out.println();
        System.out.println();
        toMerge.forEach(inter -> System.out.println("["+inter[0]+","+inter[1]+"]"));
        return toMerge.toArray(new int[toMerge.size()][2]);
    }


}
