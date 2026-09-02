class Solution {
    static int helper(int n, int a, int b, int c) {
        if(n == 0) return a;

        return helper(n-1, b, c, a+b+c);
    }
    public int tribonacci(int n) {
        return helper(n, 0, 1, 1);
    }
}