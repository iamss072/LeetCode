class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;
    public MyStack() {
        mainQ=new ArrayDeque<>();
        helperQ=new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        mainQ.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(mainQ.size()!=1)
        {
            helperQ.add(mainQ.remove());
        }
        int rem=mainQ.remove();
        mainQ=helperQ;
        helperQ=new ArrayDeque<>();
        return rem;
    }
    
    /** Get the top element. */
    public int top() {
        while(mainQ.size()!=1)
        {
            helperQ.add(mainQ.remove());
        }
        int rem=mainQ.remove();
        helperQ.add(rem);
        mainQ=helperQ;
        helperQ=new ArrayDeque<>();
        return rem;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mainQ.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */