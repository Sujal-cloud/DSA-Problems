class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int total = 0;
        int lMax = height[0];
        int rMax = height[n-1];

        int l = 0;
        int r = height.size() - 1;

        while(l < r) {
            if(height[l] <= height[r]) {
                if(lMax > height[l]) {
                    total += lMax - height[l];
                }else{
                    lMax = height[l];
                }
                l = l+1;
            }
            else{
                if(rMax > height[r]) {
                    total += rMax - height[r];
                }else{
                    rMax = height[r];
                }
                r = r - 1;
            }
        }
        return total;
    }
};