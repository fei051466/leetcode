public class Solution {
    private boolean isCap(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        else
            return false;
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1)
            return true;
        char[] wordArray = word.toCharArray();
        boolean firstCap = isCap(wordArray[0]);
        boolean secondCap = isCap(wordArray[1]);
        boolean remainCap = false;
        if (!firstCap && secondCap)
            return false;
        if (firstCap && secondCap)
            remainCap = true;
        for (int i = 2; i < wordArray.length; i++) {
            if (remainCap && !isCap(wordArray[i]))
                return false;
            if (!remainCap && isCap(wordArray[i]))
                return false;
        }
        return true;
    }
}