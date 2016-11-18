public class Solution {
    public String addStrings(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int resLength = num1.length()>num2.length()?num1.length():num2.length();
        char[] res = new char[resLength];
        int plusOne = 0;
        int resIndex = resLength - 1;
        int index1, index2;
        for (index1=num1.length()-1, index2=num2.length()-1; index1>=0 && index2>=0; index1--, index2--) {
            int curRes = num1Array[index1] + num2Array[index2] - 2 * '0' + plusOne;
            if (curRes > 9) {
                curRes = curRes % 10;
                plusOne = 1;
            }
            else {
                plusOne = 0;
            }
            res[resIndex--] = (char)(curRes + '0');
        }
        char[] remain;
        if (index1 < 0)
            remain = num2Array;
        else
            remain = num1Array;
        while (resIndex >= 0) {
            int curRes = remain[resIndex] - '0' + plusOne;
            if (curRes > 9) {
                curRes = curRes % 10;
                plusOne = 1;
            }
            else {
                plusOne = 0;
            }
            res[resIndex--] = (char)(curRes + '0');
        }
        if (plusOne == 0)
            return String.valueOf(res);
        else return "1" + String.valueOf(res);
    }
}