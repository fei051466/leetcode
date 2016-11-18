public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) return 0;
        int[] leftToRight = new int[A.length];
        int[] rightToLeft = new int[A.length];
        leftToRight[0] = A[0];
        for (int i=1; i<A.length; i++) {
            leftToRight[i] = A[i] + leftToRight[i-1];
        }
        rightToLeft[A.length-1] = A[A.length-1];
        for (int i=A.length-2; i>=0; i--) {
            rightToLeft[i] = A[i] + rightToLeft[i+1];
        }
        int max = 0;
        int first = 0;
        for (int i=0; i<A.length; i++) {
            if (i == 0) {
                for (int j=0; j<A.length; j++) {
                    first += j * A[j];
                    max = first;
                }
            }
            else {
                int cur;
                cur = first + i * leftToRight[A.length - 1 - i] - (A.length  - i) * rightToLeft[A.length - i];
                if (cur > max) max = cur;
            }
        }
        return max;
    }
}