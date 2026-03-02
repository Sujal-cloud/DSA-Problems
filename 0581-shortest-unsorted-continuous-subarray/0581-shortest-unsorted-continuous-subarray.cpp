class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        if(n <= 1) {
            return 0;
        }
        int l = -1;
        int r = -1;
        for(int i=1; i<n; i++) {
            if(nums[i] < nums[i-1]){
                l = i - 1;
                break;
            }
        }
        if(l == -1) return 0;


        for(int j=n-2; j>=0; j--) {
            if(nums[j] > nums[j+1]){
                r = j + 1;
                break;
            }
        }
        if(r == -1) return 0;

        int subMin = nums[l];
        int subMax = nums[l];

        for(int i=l; i<=r; i++) {
            subMin = min(subMin, nums[i]);
            subMax = max(subMax, nums[i]);
        }

        while(l > 0 && nums[l-1] > subMin) {
            l--;
        }
        while(r < n - 1 && nums[r+1] < subMax) {
            r++;
        }
        return r - l + 1;
    }
};