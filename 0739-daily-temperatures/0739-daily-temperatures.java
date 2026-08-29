class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            int curr = temperatures[i];

            while(!st.isEmpty() && temperatures[st.peek()] <= curr) {
                st.pop();
            }

            if(!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }
        return ans;
    }
}