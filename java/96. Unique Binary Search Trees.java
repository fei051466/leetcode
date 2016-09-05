public class Solution {
    public int numTrees(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] res = new int[n+1];
        res[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(j==1 || j==i){
                    res[i] += res[i-1];
                }
                else{
                    res[i] += res[j-1]*res[i-j];
                }
            }
        }
        return res[n];
    }
}