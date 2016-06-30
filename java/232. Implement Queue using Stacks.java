class MyQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public MyQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stackPush.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Queue is empty.");
        }
        else if (stackPop.empty()){
            while (!stackPush.empty())
                stackPop.push(stackPush.pop());
        }
        stackPop.pop();
    }

    // Get the front element.
    public int peek() {
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Queue is empty.");
        }
        else if (stackPop.empty()){
            while (!stackPush.empty())
                stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackPush.empty() && stackPop.empty();
    }
}