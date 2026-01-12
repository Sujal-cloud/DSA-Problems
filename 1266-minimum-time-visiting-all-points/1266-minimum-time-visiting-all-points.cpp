class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int totalTime = 0;
        int n = points.size();

        if(n == 1) {
            return 0;
        }

        for(int i=1; i<=n-1; i++) {
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            int x2 = points[i][0];
            int y2 = points[i][1];

            int timeBetween = max(abs(x2-x1), abs(y2-y1));

            totalTime += timeBetween;
        }
        return totalTime;
    }
};