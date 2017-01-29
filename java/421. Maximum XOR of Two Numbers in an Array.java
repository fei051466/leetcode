public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        for (int i = 31; i >=0; i--) {
            mask = mask | (1 << i);
            Set<Integer> maskNumSet = new HashSet<Integer>();
            for (int num: nums) {
                maskNumSet.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int maskNum: maskNumSet) {
                if (maskNumSet.contains(maskNum ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}