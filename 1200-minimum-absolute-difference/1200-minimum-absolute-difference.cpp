class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        int minDiff = INT_MAX;
        int n = arr.size();
        vector<pair<int, int>> temp;
        sort(arr.begin(), arr.end());

        for(int i=1; i<n; i++) {
            minDiff = min(minDiff, arr[i]-arr[i-1]);
        }
        for(int i=0; i<n-1; i++) {
            if(abs(arr[i] - arr[i+1]) == minDiff) {
                temp.emplace_back(arr[i], arr[i+1]);
            }
        }
        vector<vector<int>> ans;
        for(auto& i : temp) {
            ans.push_back({i.first, i.second});
        }
        return ans;
    }
};