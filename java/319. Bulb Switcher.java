public class Solution {
    public int bulbSwitch(int n) {
        int res = 1;
        while(res * res <= n){
            res += 1;
        }
        return res - 1;
    }
}