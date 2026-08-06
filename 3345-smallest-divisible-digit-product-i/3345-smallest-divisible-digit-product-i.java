class Solution {
    static int digitProduct(int num) {
        int ans = 1;
        while(num != 0) {
            ans *= (num % 10);
            num /= 10;
        }
        return ans;
    }
    public int smallestNumber(int n, int t) {
        int res = -1;
        while(true) {
            // n = digitProduct(n);
            if(digitProduct(n) % t == 0) {
                res = n;
                break;
            }else{
                n++;
            }
        }
        return res;
    }
}