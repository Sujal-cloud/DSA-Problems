class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        int negativeCount = 0;
        long long totalSum = 0;
        int minAbs = INT_MAX;

        for(int i=0; i<matrix.size(); i++) {
            for(int j=0; j<matrix[0].size(); j++) {
                totalSum += abs(matrix[i][j]);

                minAbs = min(minAbs, abs(matrix[i][j]));
                if(matrix[i][j] < 0) {
                    negativeCount++;
                }
            }
        }
        if(negativeCount % 2 == 0) {
            return totalSum;
        }else{
            return totalSum - 2LL * minAbs;
        }
    }
};