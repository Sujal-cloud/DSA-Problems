class Solution {
public:
    int minElement(vector<int>& nums) {
        for(int i=0; i<nums.size(); i++) {
            int sum = 0;
            int temp = nums[i];
            while(temp) {
                sum += temp % 10;
                temp /= 10;
            }
            nums[i] = sum;
        }
        sort(nums.begin(), nums.end());
        return nums[0];
    }
};