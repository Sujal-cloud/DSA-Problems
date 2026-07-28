class Solution {
    static boolean isSafe(int rowIdx, int colIdx, int n, char[][] board) {
        //we need to handle
        //horizontal -> same row different col
        //left upper diagonal -> [row-1][col-1]
        //left lower diagonal -> [row+1][col-1]

        int row = rowIdx;
        int col = colIdx;

        //1 -> horizontal
        while(col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        //2 -> left upper diagonal
        row = rowIdx;
        col = colIdx;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        //3 -> left lower
        row = rowIdx;
        col = colIdx;
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    static void solve(char[][] board, int n, int colIdx, List<List<String>> ans) {
        //base case -> if reached last colIdx, we found a valid pair
        if(colIdx >= n) {
            List<String> temp = new ArrayList<>();

            for(int i=0; i<n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        //we solve one case by putting queen in each column from leftmost row to rightmost row and then recursion handles rest.
        for(int rowIdx=0; rowIdx <n; rowIdx++) {
            if(isSafe(rowIdx, colIdx, n, board)) {
                board[rowIdx][colIdx] = 'Q';

                //recursive call for next col
                solve(board, n, colIdx + 1, ans);

                //undo ->backtracking for moving to next exploration baord needs to be reset
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