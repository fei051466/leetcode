public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = 0;
        boolean is_back = false;
        while(matrix[i][j] != target){
            if(j < matrix[0].length - 1 && matrix[i][j+1] <= target && !is_back){
                j++;
            } else if (i < matrix.length - 1 && matrix[i+1][j] <= target) {
                i++;
                is_back = false;
            } else {
                j--;
                is_back = true;
            }
            if(j == -1){
                break;
            }
        }
        if(j == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
