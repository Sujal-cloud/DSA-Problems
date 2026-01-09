class Solution {
private:
    int countAtMostK(vector<int>& nums, int k) {
        int n = nums.size();
        int res = 0;
        int left=0, right=0;
        unordered_map<int, int> freq;
        
        while(right < n) {
            freq[nums[right]]++;
            
            if(freq[nums[right]] == 1) {
                k -= 1;
            }
            
            while(k < 0) {
                freq[nums[left]]--;
                
                if(freq[nums[left]] == 0) {
                    k += 1;
                }
                left++;
            }
            
            res += (right - left + 1);
            right += 1;
        }
        return res;
    }    
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return countAtMostK(nums, k) - countAtMostK(nums, k-1);
    }
};