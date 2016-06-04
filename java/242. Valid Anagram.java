public class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;
        int[] es = new int[26];
        int[] et = new int[26];
        for (int i=0 ; i<slen; i++)
        {
            es[(int)s.charAt(i)-97] += 1;
            et[(int)t.charAt(i)-97] += 1;
        }
        for (int i=0 ; i<26; i++)
        {
            if (es[i] != et[i])
                return false;
        }
        return true;
    }
}