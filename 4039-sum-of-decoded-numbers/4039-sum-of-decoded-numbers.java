class Solution {
    long MOD = 1_000_000_007L;
    static long powerMOD(long x, long y, long MOD) {
        long res = 1;

        while(y > 0) {
            if(y % 2 == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }
    public int sumDecoded(long[] nums) {
        long sum = 0;

        for(int i=0; i<nums.length; i++) {
            long width = nums[i] % 10;
            long d = nums[i] / 10;

            int len = 0;
            long num = d;
            while(num != 0) {
                num /= 10;
                len++;
            }

            int divisor = 1;
            for(int j=0; j<(len - width); j++) {
                divisor *= 10;
            }

            long x = d / divisor;
            long y = d % divisor;

            sum = (sum + powerMOD(x, y, MOD)) % MOD;
        }
        return (int)sum;
    }
}