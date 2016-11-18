import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int cur = 1;
        while(res.size() != n){
            res.add(cur);
            if(cur * 10 <= n){
                cur *= 10;
            }
            else if(cur + 1 <= n){
                cur += 1;
                while(cur % 10 == 0){
                    cur /= 10;
                }
            }
            else{
                cur = cur / 10 + 1;
                while(cur % 10 == 0){
                    cur /= 10;
                }
            }
        }
        return res;
    }
}