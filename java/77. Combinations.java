public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        rec(res, cur, 1, n, k);
        return res;
    }

    public void rec(List<List<Integer>> res, List<Integer> cur, int min, int max, int num){
        if(max - min + 1 + cur.size() < num)
            return;
        if(cur.size() == num){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=min; i<=max; i++){
            cur.add(i);
            rec(res, cur, i+1, max, num);
            cur.remove(cur.size()-1);
        }
    }
}