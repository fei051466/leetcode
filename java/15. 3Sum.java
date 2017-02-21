public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int x = i + 1, y = nums.length - 1;
            while (x < y) {
                if (x != i + 1 && nums[x] == nums[x - 1])
                    x++;
                else if (y != nums.length - 1 && nums[y] == nums[y + 1])
                    y--;
                else if (nums[x] + nums[y] == target) {
                    List<Integer> valid = new ArrayList<Integer>();
                    valid.add(nums[i]);
                    valid.add(nums[x]);
                    valid.add(nums[y]);
                    result.add(valid);
                    x++;
                }
                else if (nums[x] + nums[y] < target) {
                    x++;
                }
                else
                    y--;
            }
        }
        return result;
    }
}