class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        for(int i = 2 * n - 1; i >= 0; i--) {
            int currIdx = i % n;
            int curr = nums[currIdx];

            while(!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            if(i < n && !st.isEmpty()) {
                nge[currIdx] = st.peek();
            }

            st.push(curr);
        }
        return nge;
    }
}