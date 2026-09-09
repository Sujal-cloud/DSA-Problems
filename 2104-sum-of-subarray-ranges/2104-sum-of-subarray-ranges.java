class Solution {
    static int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] <= curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findPGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] < curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    static int[] findPSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] > curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

        static int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            int curr = nums[i];

            while(!st.isEmpty() && nums[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static long sumOfSubarrayMax(int[] nums) {
        long sum = 0;

        int[] pge = findPGE(nums);
        int[] nge = findNGE(nums);

        for(int i=0; i<nums.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;

            long freq = 1L * left * right;
            sum += freq * nums[i];
        }
        return sum;
    }

    static long sumOfSubarrayMin(int[] nums) {
        long sum = 0;

        int[] pse = findPSE(nums);
        int[] nse = findNSE(nums);

        for(int i=0; i<nums.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            long freq = 1L * left * right;
            sum += freq * nums[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumOfSubarrayMax(nums) - sumOfSubarrayMin(nums);
    }
}