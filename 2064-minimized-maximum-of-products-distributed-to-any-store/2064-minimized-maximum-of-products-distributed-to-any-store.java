class Solution {
    static boolean isValid(int n, int[] quantities, int mid) {
        int cnt = 0;

        for(int q : quantities) {
            if(q % mid == 0) {
                cnt += q/mid;
            }else{
                cnt += (q/mid) + 1;
            }
        }
        return cnt <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int s = 1;
        int e = -1;
        for(int quantity : quantities) {
            e = Math.max(e, quantity);
        }

        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;

            if(isValid(n, quantities, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}