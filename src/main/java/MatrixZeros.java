import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setZeroes_1(matrix);
    }

    public static void setZeroes_1(int[][] matrix) {
        List<List<Integer>> indexes = new ArrayList<>();
        int m = matrix.length;
        int n =matrix[0].length;

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j]==0){
                    indexes.add(Arrays.asList(i,j));
                }
            }
        }

        for(int i=0;i<indexes.size(); i++){
            matrix[indexes.get(i).get(0)] = new int[n];
            for(int j=0;j<m;j++){
                matrix[j][indexes.get(i).get(1)]=0;
            }
        }

    }

    public static void setZeroes_2(int[][] matrix) {
        int m = matrix.length;
        int n =matrix[0].length;

        List<List<Integer>> indexes = new ArrayList<>();
        int[] all = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray();

        int i=0;
        for(int j=0; j<all.length;j++){
            if(j>0 && j%n==0) i++;

            if(all[j]==0){
                int k = i==0 ? j : j%n;
                indexes.add(Arrays.asList(i,k));
            }
        }

        for(i=0;i<indexes.size(); i++){
            matrix[indexes.get(i).get(0)] = new int[n];
            for(int j=0;j<m;j++){
                matrix[j][indexes.get(i).get(1)]=0;
            }
        }

    }
}
