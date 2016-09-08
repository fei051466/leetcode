public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for(int j=0; j<res.size(); j++){
                List<Integer> cur = res.get(j);
                for(int k=0; k<cur.size()+1; k++){
                    cur.add(k, nums[i]);
                    List<Integer> temp = new ArrayList<Integer>(cur);
                    current.add(temp);
                    cur.remove(k);
                }
            }
            res = new ArrayList<List<Integer>>(current);
        }
        return res;
    }

}