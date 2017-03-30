public class Solution {
    public String removeKdigits(String num, int k) {
        char[] numArray = num.toCharArray();
        int length = num.length() - k;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        int curLength = 0;
        while (curLength != length) {
            int min = numArray[i] - '0';
            int minIndex = i;
            for (int j = 1; j <= k; j++) {
                if (numArray[i + j] - '0' < min) {
                    min = numArray[i + j] - '0';
                    minIndex = i + j;
                }
            }
            k -= (minIndex - i);
            i = minIndex + 1;
            if (sb.length() != 0 || min != 0)
                sb.append(min);
            curLength++;
        }

        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }
}