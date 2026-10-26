class Solution {
    static long dfs(int[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0) {
            return 0;
        }

        long total = grid[row][col];
        grid[row][col] = 0;

        total += dfs(grid, row, col-1);
        total += dfs(grid, row, col+1);
        total += dfs(grid, row-1, col);
        total += dfs(grid, row+1, col);

        return total;
    }
    public int countIslands(int[][] grid, int k) {
        int cnt = 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] != 0) {
                    long total = dfs(grid, i, j);

                    if(total % k == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}