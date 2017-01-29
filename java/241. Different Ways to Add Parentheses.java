public class Solution {
    private int computeTwoNum(List<Character> operators, List<Integer> nums) {
        int num1 = nums.get(0);
        int num2 = nums.get(1);
        char operator = operators.get(0);
        int curResult;
        if (operator == '+') {
            curResult = num1 + num2;
        }
        else if (operator == '-') {
            curResult = num1 - num2;
        }
        else {
            curResult = num1 * num2;
        }
        return curResult;
    }

    private void compute(List<Character> operators, List<Integer> nums, List<Integer> result, int index) {
        if (nums.size() == 2) {
            result.add(computeTwoNum(operators, nums));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            List<Character> curOperator = new LinkedList<Character>();
            char tmpOperator = operators.get(i - 1);
            curOperator.add(tmpOperator);
            List<Integer> curNums = new LinkedList<Integer>();
            int num1 = nums.get(i - 1);
            int num2 = nums.get(i);
            curNums.add(num1);
            curNums.add(num2);
            int curResult = computeTwoNum(curOperator, curNums);
            operators.remove(i - 1);
            nums.remove(i);
            nums.remove(i - 1);
            nums.add(i - 1, curResult);
            compute(operators, nums, result, i == 1 ? 1 : i - 1);
            nums.remove(i - 1);
            nums.add(i - 1, num1);
            nums.add(i, num2);
            operators.add(i - 1, tmpOperator);
        }
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        List<Character> operators = new LinkedList<Character>();
        List<Integer> nums = new LinkedList<Integer>();
        int curNum = 0;
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                operators.add(curChar);
                nums.add(curNum);
                curNum = 0;
            }
            else {
                curNum = curNum * 10 + curChar - '0';
            }
        }
        nums.add(curNum);
        if (nums.size() == 1) 
            return nums;
        compute(operators, nums, result, 1);
        return result;
    }
}