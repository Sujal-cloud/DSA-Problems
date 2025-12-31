class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, bool> mapping;

        for(int x : nums) {
            if(mapping[x] == true) {
                return true;
            }
            mapping[x] = true;
        }
        return false;
    }
};