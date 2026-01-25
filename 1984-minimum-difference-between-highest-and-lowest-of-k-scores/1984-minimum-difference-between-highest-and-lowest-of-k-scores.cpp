class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        if(nums.size() == 0 || nums.size() == 1 || k == 1) {
            return 0;
        }
        sort(nums.begin(), nums.end());

        int diff = nums[k-1] - nums[0];
        int minDiff = diff;
        
        for(int i=k; i<nums.size(); i++) {
            diff = nums[i] - nums[i-k+1];
            minDiff = min(minDiff, diff);
        }
        return minDiff;
    }
};