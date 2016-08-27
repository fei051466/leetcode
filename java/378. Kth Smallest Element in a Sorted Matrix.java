public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] columns = new int[matrix.length];
        int res = Integer.MAX_VALUE;
        while(k-- != 0){
            int i = 0;
            int temp = 0;
            res = Integer.MAX_VALUE;
            do{
                if(columns[i] == matrix.length){
                    i++;
                    continue;
                }
                if(matrix[i][columns[i]] < res){
                    res = matrix[i][columns[i]];
                    temp = i;
                }
                i++;
            }
            while(i < columns.length);
            columns[temp]++;
        }
        return res;
    }
}