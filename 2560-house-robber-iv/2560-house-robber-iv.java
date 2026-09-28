class Solution {
    static boolean isValid(int[] nums, int k, int cap) {
        int cnt = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= cap) {
                cnt++;
                i++;
            }
        }


        return cnt >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;

        for(int num : nums) {
            s = Math.min(s, num);
            e = Math.max(e, num);
        }

        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;

            if(isValid(nums, k, mid)) {
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}