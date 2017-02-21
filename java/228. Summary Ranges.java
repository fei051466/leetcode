public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        
        int start = nums[0];
        int pre = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre + 1) {
                if (start == pre) {
                    result.add(String.valueOf(start));
                }
                else {
                    result.add(String.valueOf(start) + "->" + String.valueOf(pre));
                }
                start = nums[i];
                pre = nums[i];
            }
            else {
                pre = nums[i];
            }
        }
        if (start == pre) {
            result.add(String.valueOf(start));
        }
        else {
            result.add(String.valueOf(start) + "->" + String.valueOf(pre));
        }
        
        return result;
    }
}