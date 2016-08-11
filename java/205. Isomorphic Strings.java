public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        char[] sreplace = new char[128];
        char[] treplace = new char[128];
        for (int i=0; i<sArr.length; i++){
            char current_sreplace = sreplace[(int)sArr[i]];
            if(current_sreplace != '\u0000' && current_sreplace != tArr[i])
                return false;
            else
                sreplace[(int)sArr[i]] = tArr[i];
            char current_treplace = treplace[(int)tArr[i]];
            if(current_treplace != '\u0000' && current_treplace != sArr[i])
                return false;
            else
                treplace[(int)tArr[i]] = sArr[i];
            
        }
        return true;
    }
}