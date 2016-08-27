public class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] mask = new int[words.length];
        for(int i=0; i<words.length; i++){
            char[] charArray = words[i].toCharArray();
            for(int j=0; j<charArray.length; j++){
                mask[i] |= 1 << (charArray[j] - 'a');
            }
        }
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                if((mask[i] & mask[j]) == 0){
                    if(res <  words[i].length() * words[j].length()){
                        res = words[i].length() * words[j].length();
                    }
                }
            }
        }
        return res;
    }
}