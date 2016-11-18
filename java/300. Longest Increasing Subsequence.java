public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] < res.get(res.size()-1)){
                for(int j=0; j<res.size(); j++){
                    if(res.get(j) >= nums[i]){
                        res.remove(j);
                        res.add(j, nums[i]);
                        break;
                    }
                }
            }
            else if (nums[i] > res.get(res.size()-1)){
                res.add(nums[i]);
            }
        }
        return res.size();
    }
}