class Solution {
public:
    int maximizeSquareArea(int m, int n, vector<int>& hFences, vector<int>& vFences) {
        vector<int> H;
        H.push_back(1);
        for(int i=0; i<hFences.size(); i++) {
            H.push_back(hFences[i]);
        }
        H.push_back(m);

        vector<int> V;
        V.push_back(1);
        for(int i=0; i<vFences.size(); i++) {
            V.push_back(vFences[i]);
        }
        V.push_back(n);

        sort(H.begin(), H.end());
        sort(V.begin(), V.end());

        unordered_set<long long> heights;
        unordered_set<long long> widths;

        for(int i=0; i<H.size(); i++) {
            for(int j=i+1; j<H.size(); j++) {
                heights.insert(H[j] - H[i]);
            }
        }
        for(int i=0; i<V.size(); i++) {
            for(int j=i+1; j<V.size(); j++) {
                widths.insert(V[j] - V[i]);
            }
        }

        long long maxSide = 0;
        const long long MOD = 1e9 + 7;
        for(auto h : heights) {
            if(widths.count(h)){
                maxSide = max(maxSide, h);
            }
        }

        if(maxSide == 0) {
            return -1;
        }else{
            return (maxSide*maxSide) % MOD;
        }
    }
};