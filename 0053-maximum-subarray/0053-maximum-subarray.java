class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}