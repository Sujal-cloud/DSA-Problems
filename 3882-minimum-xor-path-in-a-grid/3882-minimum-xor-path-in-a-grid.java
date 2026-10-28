class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        int xor = grid[0][0];
        for(int j=1; j<n; j++) {
            xor ^= grid[0][j];
            dp[0][j][xor] = true;
        }

        xor = grid[0][0];
        for(int i=1; i<m; i++) {
            xor ^= grid[i][0];
            dp[i][0][xor] = true;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                for(int x=0; x<1024; x++) {
                    int prevXor = x ^ grid[i][j];

                    if(dp[i-1][j][prevXor] || dp[i][j-1][prevXor]) {
                        dp[i][j][x] = true;
                    }
                }
            }
        }

        for(int x=0; x<1024; x++) {
            if(dp[m-1][n-1][x]) {
                return x;
            }
        }
        return 0;
    }
}