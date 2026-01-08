class Solution {
public:
    double trimMean(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int n = arr.size();
        int k = (n / 20);
        int start = k;
        int end = n - k;


        int newSize = n - (n/10);
        long long sum = 0;
        for(int i=start; i<end; i++) {
            sum += arr[i];
        }
        double mean = (double)sum / newSize;

        return mean;
    }
};