class Solution {
public:
    vector<int> findNSE(vector<int>& arr) {
        stack<int> st;
        vector<int> ans(arr.size());
        for(int i=arr.size() - 1; i>=0; i--) {
            while(!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.empty() ? arr.size() : st.top();
            st.push(i);
        }
        return ans;
    }

    vector<int> findPSEE(vector<int>& arr) {
        stack<int> st;
        vector<int> ans(arr.size());
        for(int i=0; i<arr.size(); i++) {
            while(!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        return ans;
    }
    int sumSubarrayMins(vector<int>& arr) {
        vector<int> nse = findNSE(arr);
        vector<int> psee = findPSEE(arr);
        int mod = 1e9 + 7;
        int total = 0;
        for(int i=0; i<arr.size(); i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            total = ((total + (left*right) * 1LL * arr[i]) % mod) % mod;

        }
        return total;
    }
};