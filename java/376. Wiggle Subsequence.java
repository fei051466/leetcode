import java.util.Stack;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int index = 1;
        while(index < nums.length && nums[index] == nums[0])
            index++;
        if(index == nums.length)
            return 1;
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(nums[0]);
        myStack.push(nums[index]);
        boolean isIncrease = nums[index] > nums[0];
        while(++index < nums.length){
            if(isIncrease){
                if(nums[index] > myStack.peek()){
                    myStack.pop();
                    myStack.push(nums[index]);
                }
                else if(nums[index] < myStack.peek()){
                    myStack.push(nums[index]);
                    isIncrease = false;
                }
            }
            else{
                if(nums[index] > myStack.peek()){
                    myStack.push(nums[index]);
                    isIncrease = true;
                }
                else if(nums[index] < myStack.peek()){
                    myStack.pop();
                    myStack.push(nums[index]);
                }
            }
        }
        return myStack.size();
    }
}