public class Solution {
    public String multiply(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int[] result = new int[num1.length() + num2.length()];
        // int[] plusOne = new int[num1.length() + num2.length()];
        int plus = 0;
        int k = 0;


        for (int i = num2Array.length - 1; i >=0; i--) {
            k = result.length - num2Array.length + i;
            for (int j = num1Array.length - 1; j >= 0; j--) {
                result[k] = (num2Array[i] - '0') * (num1Array[j] - '0') + result[k] + plus;
                if (result[k] > 9) {
                    plus = result[k] / 10;
                    result[k] = result[k] % 10;
                }
                else {
                    plus = 0;
                }
                k--;
            }
            if (plus != 0) {
                result[k] = plus;
                plus = 0;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0)
                continue;
            sb.append(result[i]);
            if (sb.length() == 1 && result[i] == 0)
                break;
        }

        return sb.toString();
    }
}