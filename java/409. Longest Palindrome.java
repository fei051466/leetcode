public class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        int[] counter = new int[2*26];
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            if (c >= 'a' && c <= 'z') {
                counter[c - 'a']++;
            }
            else
                counter[c - 'A' + 26]++;
        }
        boolean oneMore = false;
        for (int num: counter) {
            if (num % 2 == 0) {
                res += num;
            }
            else {
                res += num - 1;
                oneMore = true;
            }
        }
        if (oneMore) res += 1;
        return res;
    }
}