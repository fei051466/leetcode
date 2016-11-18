public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int length = n - m + 1;
        int base = 1;
        int mask = 0xFFFFFFFE;
        n = n & m;
        while (length >= base + 1) {
            n &= mask;
            if (base > Integer.MAX_VALUE / 2)
                break;
            base *= 2;
            mask = mask << 1;
        }
        return n;
    }
}