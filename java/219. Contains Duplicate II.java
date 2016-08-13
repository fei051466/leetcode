public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2)
            return false;
        HashMap<Integer, Integer> value_index_map = new HashMap<Integer, Integer>();
        for(int index=0; index<nums.length; index++){
            if(value_index_map.containsKey(nums[index])){
                if(index-value_index_map.get(nums[index]) <= k)
                    return true;
            }
            value_index_map.put(nums[index], index);
        }
        return false;
    }
}