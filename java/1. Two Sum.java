public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            if(dict.containsKey(target-nums[i])){
                res[0] = dict.get(target-nums[i]);
                res[1] = i;
                break;
            }
            else{
                dict.put(nums[i],i);
            }
        }
        return res;
    }
}