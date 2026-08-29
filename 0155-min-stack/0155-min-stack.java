class MinStack {
    private Stack<Long> st;
    private long mini;
    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        long val = (long) value;
        if(st.isEmpty()) {
            st.push(val);
            mini = val;
        }else{
            if(val >= mini) {
                st.push(val);
            }else{
                long newVal = (2*val) - mini;
                st.push(newVal);
                mini = val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        long x = st.peek();
        st.pop();

        if(x < mini) {
            mini = (2*mini) - x;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        long top = st.peek();
        if(mini < top) {
            return (int)top;
        }
        return (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */