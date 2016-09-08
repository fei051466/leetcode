import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack my_stack = new Stack();
        char[] char_array = s.toCharArray();
        int index = 0;
        String res = "";
        while (index < char_array.length) {
            if (char_array[index] != ']')
                my_stack.push(char_array[index++]);
            else {
                int num = 0;
                String repeat_string = "";
                while (my_stack.peek().toString().charAt(0) != '[') {
                    repeat_string = my_stack.pop().toString() + repeat_string;
                }
                my_stack.pop();
                int mul = 1;
                while(!my_stack.isEmpty()){
                    char ch = my_stack.peek().toString().charAt(0);
                    if (ch >= '0' && ch <= '9') {
                        num += mul * (ch - '0');
                        mul *= 10;
                        my_stack.pop();
                    }
                    else{
                        break;
                    }
                }
                char[] repeat_char = repeat_string.toCharArray();
                num = num == 0? 1: num;
                while (num-- != 0) {
                    for (char c : repeat_char) {
                        my_stack.push(c);
                    }
                }
                index++;
            }
        }
        while (!my_stack.isEmpty()) {
            res = my_stack.pop().toString() + res;
        }
        return res;
    }
}
