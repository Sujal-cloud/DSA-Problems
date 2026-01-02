class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for(int i : nums){
            if(i == 0) countZero++;
            else if(i == 1) countOne++;
            else if(i == 2) countTwo++;
        }

        int i=0;
        for(int j=0; j<countZero; j++){
            nums[i++] = 0;
        }
        for(int j=0; j<countOne; j++) {
            nums[i++] =  1;
        }
        for(int j=0; j<countTwo; j++) {
            nums[i++] = 2;
        }
    }
};