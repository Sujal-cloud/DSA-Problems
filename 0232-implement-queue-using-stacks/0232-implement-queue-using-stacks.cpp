class MyQueue {
    stack<int> A;
    stack<int> B;
public:
    MyQueue() {}
    
    void push(int x) {
        A.push(x);
    }
    
    int pop() {
        if(A.empty() && B.empty()) {
            return -1;
        }
        if(!B.empty()) {
            int ans = B.top();
            B.pop();
            return ans;
        }else{
            while(!A.empty()) {
                B.push(A.top());
                A.pop();
            }
            int ans = B.top();
            B.pop();
            return ans;
        }
    }
    
    int peek() {
        if(A.empty() && B.empty()) {
            return -1;
        }
        if(!B.empty()) {
            return B.top();
        }else{
            while(!A.empty()) {
                B.push(A.top());
                A.pop();
            }
            return B.top();
        }
    }
    
    bool empty() {
        return A.empty() && B.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */