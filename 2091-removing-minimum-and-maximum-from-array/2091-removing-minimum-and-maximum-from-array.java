class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if(n == 1) return 1;

        int mini = 0;
        int maxi = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] < nums[mini]) {
                mini = i;
            }
            if(nums[i] > nums[maxi]) {
                maxi = i;
            }
        }
        int i = Math.min(mini, maxi);
        int j = Math.max(mini, maxi);

        int op1 = j+1;
        int op2 = n-i;
        int op3 = (i+1) + (n-j);

        int cnt = Math.min(op1, Math.min(op2, op3));
        return cnt;
    }
}