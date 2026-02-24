class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        long long ans;
        int n = nums.size();

        int minDiff = INT_MAX;
        for(int i=0; i<=n-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = n - 1;

            while(left < right) {
                long long currSum = (long long) nums[i] + nums[left] + nums[right];

                if(abs(target - currSum) < minDiff) {
                    minDiff = abs(target - currSum);
                    ans = currSum;
                }

                if(currSum < target) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
};