class Solution {
    static int[] nextSmaller(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            int curr = arr[i];

            while(!st.isEmpty() && st.peek() > curr) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }

            st.push(curr);
        }
        return ans;
    }
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        int[] ans = new int[n];
        int[] nse = nextSmaller(prices);

        for(int i=0; i<n; i++) {
            int disc = 0;

            if(nse[i] == -1) {
                disc = 0;
            }else{
                disc = nse[i];
            }

            ans[i] = prices[i] - disc;
        }
        return ans;
    }
}