class Solution {
    static int solve(int[] arr, int s, int e) {
        if(s >= e) {
            return s;
        }
        int mid = s + (e-s)/2;

        if(arr[mid] > arr[mid + 1]) {
            return solve(arr, s, mid);
        }else{
            return solve(arr, mid + 1, e);
        }
    }
    public int peakIndexInMountainArray(int[] arr) {
        return solve(arr, 0, arr.length - 1);
    }
}