class Solution {
    static int[] findNSE(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            int curr = arr[i];

            while(!st.isEmpty() && arr[st.peek()] >= curr) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }
    static int[] findPSE(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            int curr = arr[i];

            while(!st.isEmpty() && arr[st.peek()] > curr) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int mod = (int)(1e9 + 7);

        int n = arr.length;

        int[] pse = findPSE(arr);
        int[] nse = findNSE(arr);

        for(int i=0; i<n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            long totalSubarray = (left * right) % mod;
            sum = (sum + (totalSubarray * arr[i]) % mod) % mod;
        }
        return (int)sum;
    }
}