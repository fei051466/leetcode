import java.util.Stack;

public class MinStack {

    Stack<Integer> all_stack;
    Stack<Integer> min_stack;
    /** initialize your data structure here. */
    public MinStack() {
        all_stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }

    public void push(int x) {
        all_stack.push(x);
        if(min_stack.size() == 0 || min_stack.peek() >= x){
            min_stack.push(x);
        }
    }

    public void pop() {
        if(min_stack.peek().equals(all_stack.peek()))
            min_stack.pop();
        all_stack.pop();
    }

    public int top() {
        return all_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */