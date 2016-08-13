public class Solution {
    public boolean isValid(String s) {
        char[] string_array = s.toCharArray();
        Stack<String> my_stack = new Stack<String>();
        for(int index=0; index<string_array.length; index++){
            switch (string_array[index]){
                case '(':
                    my_stack.add("(");
                    break;
                case ')':
                    if(my_stack.size() == 0)
                        return false;
                    if(!my_stack.peek().equals("("))
                        return false;
                    my_stack.pop();
                    break;
                case '[':
                    my_stack.add("[");
                    break;
                case ']':
                    if(my_stack.size() == 0)
                        return false;
                    if(!my_stack.peek().equals("["))
                        return false;
                    my_stack.pop();
                    break;
                case '{':
                    my_stack.add("{");
                    break;
                case '}':
                    if(my_stack.size() == 0)
                        return false;
                    if(!my_stack.peek().equals("{"))
                        return false;
                    my_stack.pop();
                    break;
            }
        }
        if(my_stack.size() == 0)
            return true;
        else {
            return false;
        }
    }
}