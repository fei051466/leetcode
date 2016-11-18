public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int head = 0;
        int tail = nums.length-1;
        while (head <= tail) {
            int mid = (tail - head) / 2 + head;
            if (nums[mid] < target) {
                head = mid + 1;
            }
            else if (nums[mid] >= target) {
                tail = mid - 1;
            }
        }
        if (head == nums.length) {
            start = nums[tail]==target?tail:-1;
        }
        else if (tail == -1) {
            start = nums[head]==target?head:-1;
        }
        else if (nums[head] != target && nums[tail] != target) {
            start = -1;
        }
        else if (nums[tail] == target) {
            start = tail;
        }
        else {
            start = head;
        }
        int[] res = new int[2];
        res[0] = start;
        head = 0;
        tail = nums.length-1;
        while (head <= tail) {
            int mid = (tail - head) / 2 + head;
            if (nums[mid] <= target) {
                head = mid + 1;
            }
            else if (nums[mid] > target) {
                tail = mid - 1;
            }
        }
        if (head == nums.length) {
            end = nums[tail]==target?tail:-1;
        }
        else if (tail == -1) {
            end = nums[head]==target?head:-1;
        }
        else if (nums[head] != target && nums[tail] != target) {
            end = -1;
        }
        else if (nums[tail] == target) {
            end = tail;
        }
        else {
            end = head;
        }
        res[1] = end;
        return res;
    }
}