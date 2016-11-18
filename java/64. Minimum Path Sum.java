public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(i == 0 && j == 0){
                    res[i][j] = grid[i][j];
                }
                else if (i == 0){
                    res[i][j] = res[i][j-1] + grid[i][j];
                }
                else if (j == 0){
                    res[i][j] = res[i-1][j] + grid[i][j];
                }
                else{
                    res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
                }
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}