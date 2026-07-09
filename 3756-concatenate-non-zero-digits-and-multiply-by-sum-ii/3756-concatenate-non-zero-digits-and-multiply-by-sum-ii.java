class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefSum = new long[n+1];
        long[] prefNums = new long[n+1];
        long[] pow10 = new long[n+1];
        int[] pos = new int[n+1];

        long MOD = 1_000_000_007;
        int nonZero = 0;

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch != '0') {
                int digit = ch - '0';
                nonZero++;
                prefSum[nonZero] = prefSum[nonZero - 1] + digit;
                prefNums[nonZero] = (prefNums[nonZero - 1]* 10 + digit) % MOD;
            }
            pos[i+1] = nonZero;
        }

        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int idxL = pos[l];
            int idxR = pos[r+1];

            if(idxL == idxR) {
                res[i] = 0;
                continue;
            }

            long digitSum = prefSum[idxR] - prefSum[idxL];
            int numDigits = idxR - idxL;

            long x = (prefNums[idxR] - (prefNums[idxL] * pow10[numDigits]) % MOD + MOD);

            res[i] = (int) ((x * digitSum) % MOD);
        }
        return res;
    }
}