public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long min;
        int first;
        int head;
        int tail;
        long curSum;
        long curTarget;
        long result = target + Integer.MAX_VALUE;

        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            first = nums[firstIndex];
            curTarget = target - first;
            min = curTarget + Integer.MAX_VALUE;
            curSum = min - first;
            int[] remainNum = new int[nums.length - 1];
            int i = 0, j = 0;
            while (i < nums.length) {
                if (i != firstIndex) {
                    remainNum[j] = nums[i];
                    i++;
                    j++;
                }
                else {
                    i++;
                }
            }
            head = 0;
            tail = remainNum.length - 1;
            while (head != tail) {
                curSum = remainNum[head] + remainNum[tail];
                if (Math.abs(curSum - curTarget) < Math.abs(min - curTarget))
                    min = curSum;
                if (curSum < curTarget) {
                    head++;
                }
                else if (curSum > curTarget)
                    tail--;
                else {
                    return target;
                }
            }
            if (Math.abs(min + first - target) < Math.abs(result - target))
                result = min + first;

        }

        return (int)result;
    }
}