class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;

        int cnt = 0;
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        int avg = sum / k; // we have avg of first subarray
        if(avg >= threshold) {
            cnt++;
        }
        for(int i=k; i<n; i++) {
            sum += arr[i] - arr[i-k];
            avg = sum / k;

            if(avg >= threshold) {
                cnt++;
            }
        }
        return cnt;
    }
}