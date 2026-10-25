class Solution {
    static void dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if(grid[i][m-1] == 0) {
                dfs(grid, i, m-1);
            }
        }

        for(int j=0; j<m; j++) {
            if(grid[0][j] == 0) {
                dfs(grid, 0, j);
            }
            if(grid[n-1][j] == 0) {
                dfs(grid, n-1, j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
}