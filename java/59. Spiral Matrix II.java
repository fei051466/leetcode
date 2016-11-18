public class Solution {
    public int[][] generateMatrix(int n) {
        int cur = 0;
        int i = 0;
        int j = 0;
        int[][] res = new int[n][n];
        int direction = 0;
        int maxRight = n - 1;
        int maxBottom = n - 1;
        int minLeft = 0;
        int minTop = 1;
        while(cur++ < n * n){
            res[i][j] = cur;
            if(direction == 0){
                j++;
                if(j > maxRight){
                    j--;
                    i++;
                    direction = 1;
                    maxRight--;
                }
            }
            else if(direction == 1){
                i++;
                if(i > maxBottom){
                    i--;
                    j--;
                    direction = 2;
                    maxBottom--;
                }
            }
            else if(direction == 2){
                j--;
                if(j < minLeft){
                    j++;
                    i--;
                    direction = 3;
                    minLeft++;
                }
            }
            else if(direction == 3){
                i--;
                if(i < minTop){
                    i++;
                    j++;
                    direction = 0;
                    minTop++;
                }
            }
        }
        return res;
    }
}