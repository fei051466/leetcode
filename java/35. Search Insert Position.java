public class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length-1;
        int mid = 0;

        while(head <= tail){
            mid = (tail - head) / 2 + head;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        if(tail < 0)
            return 0;
        if(head > nums.length-1)
            return nums.length;
        return head;
    }
}