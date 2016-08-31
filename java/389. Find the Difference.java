public class Solution {
    public char findTheDifference(String s, String t) {
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        int[] count = new int[26];
        for(int i=0; i<charArrayS.length; i++){
            count[charArrayS[i] - 'a'] += 1;
        }
        for(int j=0; j<charArrayT.length; j++){
            if(count[charArrayT[j] - 'a'] == 0){
                return charArrayT[j];
            }
            else{
                count[charArrayT[j] - 'a'] -= 1;
            }
        }
        return 'a';
    }
}