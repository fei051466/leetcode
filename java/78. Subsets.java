import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        calSubsets(res, cur, nums, 0, nums.length);
        return res;
    }
    public void calSubsets(List<List<Integer>> res, List<Integer> cur, int[] nums, int index, int max){
        if(index == max){
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        calSubsets(res, cur, nums, index+1, max);
        cur.add(nums[index]);
        calSubsets(res, cur, nums, index+1, max);
        cur.remove(cur.size() - 1);

    }
}