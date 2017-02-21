public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            count++;
            if (n % 2 == 0) {
                n = n / 2;
            }
            else if (n == 3) {
                n = 2;
            }
            else if (n == 2147483647) {
                n = (n - 1) / 2 + 1;
                count++;
            }
            else if (n % 4 == 1) {
                n = n -1;
            }
            else {
                n = n + 1;
            }
        }
        return count;
    }
}