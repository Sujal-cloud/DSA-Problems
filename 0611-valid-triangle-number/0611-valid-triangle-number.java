class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int cnt = 0;

        for(int maxi=n-1; maxi>=2; maxi--) {
            int left = 0;
            int right = maxi - 1;

            while(left < right) {
                if(nums[left] + nums[right] > nums[maxi]) {
                    cnt += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return cnt;
    }
}