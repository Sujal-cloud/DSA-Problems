class Solution {
    static boolean isValid(int[] bloomDay, int m, int k, int mid) {
        int flowerCnt = 0;
        int bCount = 0;

        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                flowerCnt++;
                if(flowerCnt == k) {
                    bCount++;
                    flowerCnt = 0;
                }
            }else{
                flowerCnt = 0;
            }
        }
        return bCount >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(m*k > n) return -1;

        int s = 1;
        int e = -1;
        for(int bloom : bloomDay) {
            if(bloom > e) {
                e = bloom;
            }
        }    

        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;

            if(isValid(bloomDay, m, k, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}