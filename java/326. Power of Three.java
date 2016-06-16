public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        int max = Integer.MAX_VALUE;
        int maxPower = (int)Math.pow(3, (int)(Math.log(max) / Math.log(3)));
        return maxPower%n==0?true:false;
    }
}