class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxCount = Integer.MIN_VALUE;
        int zeroCount = 0;

        int left = 0;
        for(int right=0; right<n; right++) {
            if(nums[right] == 0) zeroCount++;

            while(zeroCount > k) {
                if(nums[left] == 0) zeroCount--;
                left++;
                
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }
}