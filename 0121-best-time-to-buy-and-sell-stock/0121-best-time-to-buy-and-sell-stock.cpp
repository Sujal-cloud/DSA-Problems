class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int min = INT_MAX;

        int maxProfit = 0;
        for(int i : prices) {
            if(i < min) {
                min = i;
            }else {
                maxProfit = max(maxProfit, i - min);
            }
        }
        return maxProfit;
    }
};