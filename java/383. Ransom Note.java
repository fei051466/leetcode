public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mgz_count = new int[26];
        int[] rsn_count = new int[26];
        char[] mgz_array = magazine.toCharArray();
        char[] rsn_array = ransomNote.toCharArray();

        for(int i=0; i<mgz_array.length; i++){
            mgz_count[mgz_array[i] - 'a']++;
        }
        for(int j=0; j<rsn_array.length; j++){
            rsn_count[rsn_array[j] - 'a']++;
        }
        for(int k=0; k<26; k++){
            if(rsn_count[k] > mgz_count[k])
                return false;
        }
        return true;
    }
}