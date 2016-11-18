public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        int[] repeatNum = new int[26];
        boolean[] valid = new boolean[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++)
            repeatNum[charArray[i] - 'a']++;
        boolean totalValid = true;
        for (int i = 0; i < 26; i++) {
            if (repeatNum[i] > 0 && repeatNum[i] < k) {
                valid[i] = false;
                totalValid = false;
            } else
                valid[i] = true;
        }
        if (totalValid) return s.length();
        int maxLength = 0;
        int last = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (!valid[charArray[i] - 'a']) {
                maxLength = Math.max(maxLength, longestSubstring(s.substring(last, i), k));
                last = i + 1;
            }
        }
        maxLength = Math.max(maxLength, longestSubstring(s.substring(last, s.length()), k));
        return maxLength;
    }
}
