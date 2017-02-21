public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 0);
        int[] uglys = new int[n];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            int tmp = 0;
            for (int j = 0; j < primes.length; j++) {
                tmp = uglys[pointers[j]] * primes[j];
                if (tmp < min) {
                    min = tmp;
                    minIndex = j;
                }
                else if (tmp == min) {
                    pointers[j]++;
                }
            }
            uglys[i] = min;
            pointers[minIndex]++;
        }
        return uglys[n - 1];
    }
}