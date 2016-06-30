public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int k = 1;
        while (x/k > 9){
            k *= 10;
        }
        while(x != 0){
            if (x/k != x%10)
                return false;
            x = (x % k) / 10;
            k /= 100;
        }
        return true;
    }
}