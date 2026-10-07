class Solution {
    private boolean isSafe(char[][] board, int n, int rowIdx, int colIdx) {
        int row = rowIdx;
        int col = colIdx;

        // 1. Same row
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = rowIdx;
        col = colIdx;

        // 2. Left upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = rowIdx;
        col = colIdx;

        // 3. Left lower diagonal
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    private int solve(char[][] board, int n, int colIdx) {

        // All columns successfully filled
        if (colIdx >= n) {
            return 1;
        }

        int cnt = 0;

        // Try every row in current column
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {

            if (isSafe(board, n, rowIdx, colIdx)) {
                board[rowIdx][colIdx] = 'Q';
                cnt += solve(board, n, colIdx + 1);

                board[rowIdx][colIdx] = '.';
            }
        }

        return cnt;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return solve(board, n, 0);
    }
}