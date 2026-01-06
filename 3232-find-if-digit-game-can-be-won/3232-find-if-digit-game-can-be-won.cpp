class Solution {
public:
    bool canAliceWin(vector<int>& nums) {
        int singleSum = 0;
        int doubleSum = 0;

        for(int i : nums) {
            if(i >= 0 && i <= 9) {
                singleSum += i;
            }else{
                doubleSum += i;
            }
        }
        if(singleSum != doubleSum) {
            return true;
        }
        return false;
    }
};