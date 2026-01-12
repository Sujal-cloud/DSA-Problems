class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProd = nums[0];

        for(int i=1; i<nums.size(); i++) {
            int temp = max({nums[i], nums[i]*currMax, nums[i]*currMin});

            currMin = min({nums[i], nums[i]*currMax, nums[i]*currMin});

            currMax = temp;

            maxProd = max(maxProd, currMax);
        }
        return maxProd;
    }
};