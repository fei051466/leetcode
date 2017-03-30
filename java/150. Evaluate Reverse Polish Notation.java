public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<Integer>();
        for (String token: tokens) {
            char firstChar = token.charAt(0);
            if (firstChar >= '0' && firstChar <= '9') {
                nums.push(Integer.valueOf(token));
            }
            else if (firstChar == '-' && token.length() > 1) {
                nums.push(Integer.valueOf(token));
            }
            else {
                int num2 = nums.pop();
                int num1 = nums.pop();
                if (firstChar == '+')
                    nums.push(num1 + num2);
                else if (firstChar == '-')
                    nums.push(num1 - num2);
                else if (firstChar == '*')
                    nums.push(num1 * num2);
                else
                    nums.push(num1 / num2);
            }
        }

        return nums.pop();
    }
}