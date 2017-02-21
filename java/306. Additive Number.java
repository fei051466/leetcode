public class Solution {
    private boolean valid(char[] numArray, int firstStart, int firstEnd, int secondEnd) {
        if (secondEnd == numArray.length - 1) {
            return true;
        }
        int length = Math.max(firstEnd - firstStart+ 1, secondEnd - firstEnd) + 1;
        int[] result = new int[length];
        int i = firstEnd, j = secondEnd, k = length - 1;
        int plusOne = 0;
        while (i >= firstStart || j >= firstEnd + 1 || plusOne != 0) {
            int first, second;
            if (i < firstStart) {
                first = 0;
            }
            else {
                first = numArray[i] - '0';
                i--;
            }
            if (j < firstEnd + 1) {
                second = 0;
            }
            else {
                second = numArray[j] - '0';
                j--;
            }
            int cur = first + second + plusOne;
            if (cur > 9) {
                cur = cur % 10;
                plusOne = 1;
            }
            else {
                plusOne = 0;
            }
            result[k] = cur;
            k--;
        }

        j = length - 1;
        if (k == 0)
            length--;

        if (secondEnd + length > numArray.length - 1)
            return false;

        for (i = secondEnd + length; i >= secondEnd + 1; i--) {
            if (numArray[i] - '0' != result[j])
                return false;
            j--;
        }

        return valid(numArray, firstEnd + 1, secondEnd, secondEnd + length);
    }

    public boolean isAdditiveNumber(String num) {
        char[] numArray = num.toCharArray();
        for (int i = 0; i < num.length() / 2; i++) {
            for (int j = i + 1; j < num.length() - 1; j++) {
                if (numArray[0] == '0' && i != 0)
                    continue;
                if (numArray[i + 1] == '0' && j != i + 1)
                    continue;
                if (valid(numArray, 0, i, j))
                    return true;
            }
        }
        return false;
    }
}