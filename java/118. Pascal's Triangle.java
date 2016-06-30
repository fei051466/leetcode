public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1)
            return result;
        for (int i=0; i<numRows; i++){
            List<Integer> current = new ArrayList<Integer>();
            if (i == 0){
                current.add(1);
            }
            else if (i == 1){
                current.add(1);
                current.add(1);
            }
            else{
                current.add(1);
                for (int j=1; j<i; j++){
                    current.add(result.get(i-1).get(j-1)+ result.get(i-1).get(j));
                }
                current.add(1);
            }
            result.add(current);
        }
        return result;
    }
}