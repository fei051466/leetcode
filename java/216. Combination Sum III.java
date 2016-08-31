public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = combinationSum3S(k, n, 9);
        return res;
    }
    private List<List<Integer>> combinationSum3S(int k, int n, int max){
        List<List<Integer>> current = new ArrayList<List<Integer>>();
        if(k == 1){
           List<Integer> res = new ArrayList<Integer>();
           if(n>=1 && n <= max){
               res.add(n);
           }
           current.add(res);
           return current;
        }
        for(int i=max; i>=1; i--){
            if(n <= i){
                continue;
            }
            List<List<Integer>> smaller = combinationSum3S(k-1, n-i, i-1);
            if(smaller.size() == 0){
                continue;
            }
            for(int j=0; j<smaller.size(); j++){
                List<Integer> temp = smaller.get(j);
                if(temp.size() != k-1){
                    continue;
                }
                temp.add(i);
                current.add(temp);
            }
        }
        return current;
    }
}