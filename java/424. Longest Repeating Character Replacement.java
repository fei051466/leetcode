public class Solution {
    public int characterReplacement(String s, int k) {
        char[] sArray = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < 26; i++) {
            int replaceCount = 0;
            char replaceToChar = (char)('A' + i);
            List<Integer> replaceIndex = new ArrayList<Integer>();
            int curLength = 0;
            for (int j = 0; j < sArray.length; j++) {
                if (sArray[j] == replaceToChar) {
                    curLength++;
                }
                else {
                    replaceIndex.add(j);
                    if (replaceCount < k) {
                        replaceCount++;
                        curLength++;
                    }
                    else {
                        int firstReplaceIndex = replaceIndex.get(0);
                        curLength = j - firstReplaceIndex;
                        replaceIndex.remove(0);
                    }
                }
                if (curLength > maxLength)
                    maxLength = curLength;
            }
        }

        return maxLength;
    }
}