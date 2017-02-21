public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0)
            return result;
        int[] pointers = new int[nums1.length];

        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < pointers.length; j++) {
                if (pointers[j] == nums2.length)
                    continue;
                int tmp = nums1[j] + nums2[pointers[j]];
                if (tmp < min) {
                    min = tmp;
                    minIndex = j;
                }
            }
            if (minIndex == -1)
                break;
            int[] pair = new int[2];
            pair[0] = nums1[minIndex];
            pair[1] = nums2[pointers[minIndex]];
            result.add(pair);
            pointers[minIndex]++;
        }

        return result;
    }
}