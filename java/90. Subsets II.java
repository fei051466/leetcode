import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> duplicateCount = new HashMap<Integer, Integer>();
        for(int num: nums){
            if (duplicateCount.containsKey(num))
                duplicateCount.put(num, duplicateCount.get(num) + 1);
            else
                duplicateCount.put(num, 1);
        }
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Integer> values = new ArrayList<Integer>();
        Iterator iterator = duplicateCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Integer key = (Integer) entry.getKey();
            keys.add(key);
            Integer value = (Integer) entry.getValue();
            values.add(value);
        }
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        generateSubset(keys, values, 0, cur, res);
        return res;
    }

    private void generateSubset(ArrayList<Integer> keys, ArrayList<Integer> values, int index, ArrayList cur, ArrayList<List<Integer>> res) {
         if (index == keys.size()) {
             ArrayList<Integer> temp = new ArrayList<Integer>(cur);
             res.add(temp);
         }
         else {
             for (int i=0; i<=values.get(index); i++) {
                 for(int j=0; j<i; j++){
                     cur.add(keys.get(index));
                 }
                 generateSubset(keys, values, index+1, cur, res);
                 for(int j=0; j<i; j++) {
                     cur.remove(cur.size() - 1);
                 }
             }
         }
    }
}
