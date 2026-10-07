class Solution {
    private boolean isSafe(char[][] board, int n, int rowIdx, int colIdx) {
        int row = rowIdx;
        int col = colIdx;

        //1 same row
        while(col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = rowIdx;
        col = colIdx;
        //2 left upper diagonal
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = rowIdx;
        col = colIdx;
        //3 left lower diagonal
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
    private void solve(char[][] board, int n, int colIdx, List<List<String>> ans) {
        //base case -> if we reach visit all column, we have valid ans
        if(colIdx >= n) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        //now for every row, we check all columns, from left to right
        for(int rowIdx=0; rowIdx<n; rowIdx++) {
            if(isSafe(board, n, rowIdx, colIdx)) {
                board[rowIdx][colIdx] = 'Q';

                solve(board, n, colIdx+1, ans);

                //backtrack
                board[rowIdx][colIdx] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        int colIdx = 0;

        solve(board, n, colIdx, ans);
        return ans;
    }
}