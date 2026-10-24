class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long cnt = 0;

        int left = 0;
        for(int right=0; right<n; right++) {
            if(nums[right] > maxK || nums[right] < minK) {
                left = right + 1;
            }else{
                cnt += right - left + 1;
            }
        }
        return cnt;
    }
}