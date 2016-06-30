public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        int[] temp = new int[rowIndex+1];
        if (rowIndex >= 0){
            temp[0] = 1;
        }
        if (rowIndex >= 1){
            temp[0] = 1;
            temp[1] = 1;
        }
        for (int i=2; i<rowIndex+1; i++){
            int index = i;
            temp[i] = 1;
            index -= 1;
            while(index > 0){
                temp[index] = temp[index] + temp[index-1];
                index--;
            }
        }
        for (int j=0; j<rowIndex+1; j++)
            res.add(temp[j]);
        return res;
    }
}