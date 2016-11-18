public class Solution {
    public int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int mid = 0;
        while (head <= tail) {
            mid = head + (tail - head) / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid+1])
                break;
            if (nums[mid] >= nums[0])
                head = mid + 1;
            else
                tail = mid - 1;
        }
        // nums[mid] is the biggest num in nums
        if (mid == nums.length - 1) {
            head = 0;
            tail = nums.length - 1;
        }
        else{
            if (target < nums[0]){
                head = mid + 1;
                tail = nums.length - 1;
            }
            else {
                tail = mid;
                head = 0;
            }
        }
        while (head <= tail) {
            mid = head + (tail - head) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                head = mid + 1;
            else
                tail = mid - 1;
        }
        return -1;
    }
}