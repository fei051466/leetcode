public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }
        if(n > 10){
            n = 10;
        }
        int res = 10;
        while(n != 1){
            int i = n - 1;
            int j = 9;
            while(i != 0){
                j *= 10 - n + i;
                i--;
            }
            res += j;
            n--;
        }
        return res;
    }
}