public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int j=0; j<s.length(); j++)
        {
            res = res*26 + s.charAt(j) - 'A' + 1;
        }
        return res;
    }
}