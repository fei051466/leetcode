public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        int[] pointers = new int[3];
        int[] nums = {2, 3, 5};
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j] * uglys[pointers[j]];
                if (tmp < min) {
                    min = tmp;
                    minIndex = j;
                }
                else if (tmp == min){
                    pointers[j]++;
                }
            }
            uglys[i] = min;
            pointers[minIndex]++;
        }
        return uglys[n - 1];
    }
}