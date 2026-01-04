class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        int totalSum = 0;
        for(int n : nums) {
            int divisorCount = 0;
            long long divisorSum = 0;
            int limit = sqrt(n);

            for(int i=1; i<= limit; i++) {
                if(n % i == 0) {
                    if(i == n/i) {
                        divisorCount += 1;
                        divisorSum += i;
                    }else{
                        divisorCount += 2;
                        divisorSum = divisorSum + i + n/i;
                    }
                }
                if(divisorCount > 4) {
                    break;
                }
            }

            if(divisorCount == 4) {
                totalSum += divisorSum;
            }
            
        }
        return totalSum;
    }
};