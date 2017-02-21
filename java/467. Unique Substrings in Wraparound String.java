public class Solution {
    private boolean isAdjacent(char a, char b) {
        if (a == 'z' && b == 'a')
            return true;
        else if (b - a == 1)
            return true;
        else
            return false;
    }

    private void handle(int[] vals , char start, int length) {
        for (int i = 0; i < length; i++) {
            int index = (start + i - 'a') % 26;
            if (vals[index] < i + 1) {
                vals[index] = i + 1;
            }
        }
    }

    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0)
            return 0;
        char[] pArray = p.toCharArray();
        int length = 0;
        int[] vals = new int[26];
        char start = 'a';
        int result = 0;
        for (int i = 0; i < pArray.length; i++) {
            length++;
            if (length == 1)
                start = pArray[i];
            if (i == pArray.length - 1 || !isAdjacent(pArray[i], pArray[i + 1])) {
                handle(vals, start, length);
                length = 0;
            }
        }
        for (int val: vals)
            result += val;
        return result;
    }
}