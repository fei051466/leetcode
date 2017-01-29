public class Solution {
    private void countSum(int[] A, int[] B, HashMap<Integer, Integer> sumAB) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (sumAB.containsKey(sum)) {
                    sumAB.put(sum, sumAB.get(sum) + 1);
                }
                else {
                    sumAB.put(sum, 1);
                }
            }
        }
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sumAB = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sumCD = new HashMap<Integer, Integer>();

        countSum(A, B, sumAB);
        countSum(C, D, sumCD);

        int result = 0;
        for (Integer key: sumAB.keySet()) {
            if (sumCD.containsKey(0 - key)) {
                result += sumAB.get(key) * sumCD.get(0 - key);
            }
        }

        return result;
    }
}