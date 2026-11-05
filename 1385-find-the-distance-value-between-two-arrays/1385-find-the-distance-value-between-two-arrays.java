class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;

        int cnt = 0;
        for(int i=0; i<n; i++) {
            int valid = 0;
            for(int j=0; j<m; j++) {
                if(Math.abs(arr1[i] - arr2[j]) > d) {
                    valid++;
                }
            }
            if(valid == m) cnt++;
        }
        return cnt;
    }
}