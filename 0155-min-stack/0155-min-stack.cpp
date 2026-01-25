class MinStack {
    stack<long long> st;   // 👈 long long stack
    long long mini;        // 👈 long long min

public:
    MinStack() {
        mini = LLONG_MAX;
    }

    void push(int val) {
        if (st.empty()) {
            st.push(val);
            mini = val;
            return;
        }

        if (val < mini) {
            st.push(2LL * val - mini);  // 👈 force long long math
            mini = val;
        } else {
            st.push(val);
        }
    }

    void pop() {
        if (st.empty()) return;

        long long curr = st.top();
        st.pop();

        if (curr < mini) {
            mini = 2 * mini - curr;  // decode safely
        }
    }

    int top() {
        if (st.empty()) return -1;

        long long curr = st.top();
        return (curr < mini) ? (int)mini : (int)curr;
    }

    int getMin() {
        return st.empty() ? -1 : (int)mini;
    }
};
