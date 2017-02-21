public class Solution {
    public int calculate(String s) {
        char[] sArray = s.toCharArray();
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        operator.add('+');
        int cur = 0;
        char op;
        int preNum;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == ' ')
                continue;
            if (sArray[i] >= '0' && sArray[i] <= '9')
                cur = cur * 10 + sArray[i] - '0';
            else {
                if (num.empty()) {
                    num.push(cur);
                    operator.push(sArray[i]);
                }
                else {
                    op = operator.peek();
                    if (op == '*') {
                        num.push(num.pop() * cur);
                        operator.pop();
                    }
                    else if (op == '/') {
                        num.push(num.pop() / cur);
                        operator.pop();
                    }
                    else {
                        num.push(cur);
                    }
                    operator.push(sArray[i]);
                }
                cur = 0;
            }
        }
        if (num.empty())
            return cur;

        op = operator.peek();
        if (op == '*') {
            num.push(num.pop() * cur);
            operator.pop();
        }
        else if (op == '/') {
            num.push(num.pop() / cur);
            operator.pop();
        }
        else {
            num.push(cur);
        }

        int res = 0;

        while (!num.empty()) {
            op = operator.pop();
            preNum = num.pop();
            if (op == '+') {
                res = res + preNum;
            }
            else
                res = res - preNum;
        }

        return res;
    }
}