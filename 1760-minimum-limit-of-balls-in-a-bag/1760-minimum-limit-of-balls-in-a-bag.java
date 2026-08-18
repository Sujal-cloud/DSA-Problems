class Solution {
    static boolean isValid(int[] nums, int maxOperations, int minPenalty) {
        long ops = 0;
        for(int num : nums) {
            ops += (num - 1)/minPenalty;
        }

        return ops <= maxOperations;

    }
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int ans = -1;
        int s = 1;
        int e = -1;
        for(int num : nums) {
            e = Math.max(e, num);
        }

        while(s <= e) {
            int mid = s + (e-s)/2;
            if(isValid(nums, maxOperations, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}