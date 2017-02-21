public class Solution {
    public int mySqrt(int x) {
        long tmp = 0;
        int result = 0;
        while (tmp <= x) {
            result++;
            tmp = (long)result * result;
        }
        return result - 1;
    }
}