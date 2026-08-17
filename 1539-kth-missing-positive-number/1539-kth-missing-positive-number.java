class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        if(k < arr[0]) {
            return k;
        }
        int s = 0;
        int e = n-1;

        while(s <= e) {
            int mid = s + (e-s)/2;
            
            int missingCnt = arr[mid] - mid - 1;

            if(missingCnt < k) {
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return s + k;
    }
}