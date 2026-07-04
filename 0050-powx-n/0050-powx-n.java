class Solution {
    static double solve(double x, long n) {
        if(n == 0) {
            return 1.00;
        }
        if(n < 0) {
            return solve(1/x, -n);
        }
        double half = solve(x, n/2);
        if(n % 2 == 0) {
            return half * half;
        }else{
            return x * half * half;
        }
    }
    public double myPow(double x, int n) {
        double ans = solve(x, (long)n);
        return ans;
    }
}