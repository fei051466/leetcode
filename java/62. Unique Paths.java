public class Solution {
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        int sum = m + n;
        int min = m < n ? m : n;
        long res = 1;
        for(int i=0; i<min; i++){
            res *= (sum - i);
        }
        for(int i=min; i>0; i--){
            res /= i;
        }
        return (int)res;
    }
}