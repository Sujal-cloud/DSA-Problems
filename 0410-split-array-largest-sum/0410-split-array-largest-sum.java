class Solution {
    static boolean isValid(int[] nums, int k, int mid) {
        int sum = 0;
        int subarrayCnt = 1;

        for(int i=0; i<nums.length; i++) {
            if(sum + nums[i] <= mid) {
                sum += nums[i];
            }else{
                sum = nums[i];
                subarrayCnt++;
            }

        }
        return subarrayCnt <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int s = -1;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            s = Math.max(s, num);
        }
        int e = sum;
        int ans = -1;

        while(s <= e) {
            int mid = s + (e-s)/2;
            if(isValid(nums, k, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}