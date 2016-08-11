class MyStack {
    public LinkedList<Integer> queue;
    public LinkedList<Integer> temp;
    
    public MyStack(){
        queue = new LinkedList<Integer>();
        temp = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue.size()!=1){
            temp.addLast(queue.removeFirst());
        }
        queue.removeFirst();
        while(temp.size()!=0){
            queue.addLast(temp.removeFirst());
        }
    }

    // Get the top element.
    public int top() {
        while(queue.size()!=1){
            temp.addLast(queue.removeFirst());
        }
        int result = queue.removeFirst();
        temp.addLast(result);
        while(temp.size()!=0){
            queue.addLast(temp.removeFirst());
        }
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size()==0;
    }
}