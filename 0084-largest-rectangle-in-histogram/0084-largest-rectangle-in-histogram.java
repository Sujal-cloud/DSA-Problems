class Solution {
    private int[] prevSmaller(int[] heights) {
        int[] ans = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<heights.length; i++) {
            int curr = heights[i];

            while(!st.isEmpty() && heights[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return ans;
    }
    private int[] nextSmaller(int[] heights) {
        int[] ans = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for(int i=heights.length - 1; i>=0; i--) {
            int curr = heights[i];

            while(!st.isEmpty() && heights[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? heights.length : st.peek();

            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse = nextSmaller(heights);
        int[] pse = prevSmaller(heights);

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++) {
            int h = heights[i];

            int w = (nse[i] - pse[i] - 1);

            ans = Math.max(ans, h*w);
        }

        return ans;
    }
}