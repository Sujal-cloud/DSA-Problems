class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int n = nums.length;

        int[] prefMax = new int[n];
        int[] suffixMin = new int[n];

        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, nums[i]);
            prefMax[i] = maxi;
        }

        for(int i=n-1; i>=0; i--) {
            mini = Math.min(mini, nums[i]);
            suffixMin[i] = mini;
        }

        for(int i=0; i<n; i++) {
            int score = prefMax[i] - suffixMin[i];
            if(score <= k) {
                return i;
            }
        }
        return -1;
    }
}