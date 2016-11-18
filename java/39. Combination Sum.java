import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        combination(res, cur, candidates, Integer.MIN_VALUE, 0, target);
        return res;
    }

    private  void combination(List<List<Integer>> res, List<Integer> cur, int[] candidates, int min, int last, int target){
        for(int candidate: candidates){
            if(candidate < min)
                continue;
            if(last + candidate == target){
                List<Integer> temp = new ArrayList<Integer>(cur);
                temp.add(candidate);
                res.add(temp);
            }
            else if(last + candidate < target){
                cur.add(candidate);
                combination(res, cur, candidates, candidate, last+candidate, target);
                cur.remove(cur.size()-1);
            }
        }
    }
}
