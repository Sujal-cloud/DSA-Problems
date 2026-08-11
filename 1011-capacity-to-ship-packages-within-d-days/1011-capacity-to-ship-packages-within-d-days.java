class Solution {
    static boolean isValid(int[] weights, int days, int mid) {
        int cnt = 1;
        int currWeight = 0;
        for(int i=0; i<weights.length; i++) {
            if(currWeight + weights[i] <= mid) {
                currWeight += weights[i];
            }else{
                currWeight = weights[i];
                cnt++;
            }
        }
        if(cnt > days) {
            return false;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        for(int w : weights) {
            if(w > maxi) {
                maxi = w;
            }
        }
        int s = maxi;

        int sum = 0;
        for(int w : weights) {
            sum += w;
        }
        int e = sum;
        int ans = -1;

        while(s <= e) {
            int mid = s + (e-s)/2;
            if(isValid(weights, days, mid)) {
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}