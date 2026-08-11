class Solution {
    static boolean isValid(int[] nums, int threshold, int x) {
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += (int)Math.ceil((double) nums[i]/x);
        }
        if(sum <= threshold) {
            return true;
        }
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int maxi = -1;

        for(int num : nums) {
            if(num > maxi) {
                maxi = num;
            }
        }

        int s = 1;
        int e = maxi;

        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(isValid(nums, threshold, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}