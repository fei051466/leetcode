import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> myStack = new Stack<String>();
        String[] stringArray = preorder.split(",");
        myStack.push(stringArray[0]);
        int index = 1;
        while(!myStack.empty() && index < stringArray.length){
            if(!myStack.peek().equals("#")){
                myStack.push(stringArray[index]);
                index++;
            }
            else{
                String temp = myStack.pop();
                if (!myStack.empty() && myStack.peek().equals("#")) {
                    myStack.pop();
                    if(myStack.empty())
                        return false;
                    myStack.pop();
                    myStack.push("#");
                }
                else{
                    myStack.push(temp);
                    myStack.push(stringArray[index]);
                    index++;
                }
            }
        }
        while(myStack.size() >= 3){
            String peekOne = myStack.pop();
            String peekTwo = myStack.pop();
            myStack.pop();
            if(peekOne.equals("#") && peekTwo.equals("#"))
                myStack.push("#");
            else
                return false;
        }
        if(myStack.size() == 1 && myStack.peek().equals("#")){
            return true;
        }
        else{
            return false;
        }
    }
}
