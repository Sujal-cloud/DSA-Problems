class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        int area = 0;
        vector<int> next = nextSmallerElement(heights, n);

        vector<int> prev = prevSmallerElement(heights, n);

        for(int i=0; i<n; i++) {
            int height = heights[i];
            if(next[i] == -1) {
                next[i] = n;
            }
            int width = next[i] - prev[i] - 1;

            int newArea = height * width;
            area = max(area, newArea);
        }
        return area;
    }

    vector<int> prevSmallerElement(vector<int>& arr, int n) {
        stack<int> s;
        s.push(-1);

        vector<int> ans(n);
        for(int i=0; i<n; i++) {
            int curr = arr[i];
            while(s.top() != -1 && arr[s.top()] >= curr) {
                s.pop();
            }
            ans[i] = s.top();
            s.push(i);
        }
        return ans;
    }   

    vector<int> nextSmallerElement(vector<int>& arr, int n) {
        stack<int> s;
        s.push(-1);

        vector<int> ans(n);
        for(int i=n-1; i>=0; i--) {
            int curr = arr[i];
            while(s.top() != -1 && arr[s.top()] >= curr) {
                s.pop();
            }
            ans[i] = s.top();
            s.push(i);
        }
        return ans;
    }

    int maximalRectangle(vector<vector<char>>& matrix) {
    if(matrix.empty()) return 0;

    int n = matrix.size();
    int m = matrix[0].size();

    vector<int> heights(m, 0);
    int area = 0;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(matrix[i][j] == '1')
                heights[j] += 1;
            else
                heights[j] = 0;
        }
        area = max(area, largestRectangleArea(heights));
    }
    return area;
}

};