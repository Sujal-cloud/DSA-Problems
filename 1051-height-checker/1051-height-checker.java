class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] newArr = new int[n];
        for(int i=0; i<n; i++) {
            newArr[i] = heights[i];
        }

        Arrays.sort(heights);
        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(newArr[i] != heights[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}