class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long MOD = 1_000_000_007;

        long[] prefSum = new long[n + 1];
        long[] prefHash = new long[n + 1];
        int[] pos = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int nonZeroCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                int digit = c - '0';
                nonZeroCount++;
                prefSum[nonZeroCount] = prefSum[nonZeroCount - 1] + digit;
                prefHash[nonZeroCount] = (prefHash[nonZeroCount - 1] * 10 + digit) % MOD;
            }
            pos[i + 1] = nonZeroCount;
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int idxL = pos[l]; 
            int idxR = pos[r + 1]; 

            if (idxL == idxR) {
                res[i] = 0;
                continue;
            }

            long digitSum = prefSum[idxR] - prefSum[idxL];

            int numDigits = idxR - idxL;
            long x = (prefHash[idxR] - (prefHash[idxL] * pow10[numDigits]) % MOD + MOD) % MOD;

            res[i] = (int) ((x * digitSum) % MOD);
        }

        return res;
    }
}