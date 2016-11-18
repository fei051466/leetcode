public class Solution {
    public int findNthDigit(int n) {
        int base = 9;
        int num = 1;
        int last = 1;
        long cur = last * base * num;
        while (n > cur) {
            n -= last * base * num;
            last *= 10;
            num++;
            cur = (long)last * base * num;
        }
        int index = (n - 1) / num + last;
        int remain = n % num;
        if (remain == 0) remain = num;
        while (--remain > 0) {
            last /= 10;
        }
        return index / last % 10;
    }

}