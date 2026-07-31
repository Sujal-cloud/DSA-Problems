class Solution {
    static boolean solve(char[][] board, String word, int rowIdx, int colIdx, int idx, int m, int n, boolean[][] visited) {
        // base case -> word fully traversed
        if(idx >= word.length()) {
            return true;
        }
        if(rowIdx < 0 || rowIdx >= m || colIdx < 0 || colIdx >= n) {
            return false;
        }

        visited[rowIdx][colIdx] = true;
        //recursion try all direction and go where possible


        if((rowIdx - 1 >= 0) && (!visited[rowIdx - 1][colIdx]) && (board[rowIdx - 1][colIdx] == word.charAt(idx))) {
            boolean up = solve(board, word, rowIdx - 1, colIdx, idx + 1, m, n, visited);

            if(up) return true;
        }
        if((rowIdx + 1 < m) && (!visited[rowIdx + 1][colIdx]) && board[rowIdx + 1][colIdx] == word.charAt(idx)) {
            boolean down = solve(board, word, rowIdx + 1, colIdx, idx + 1, m, n, visited);

            if(down) return true;
        }
        if((colIdx - 1 >= 0) && (!visited[rowIdx][colIdx - 1]) && (board[rowIdx][colIdx - 1] == word.charAt(idx))) {
            boolean left = solve(board, word, rowIdx, colIdx - 1, idx + 1, m, n, visited);

            if(left) return true;
        }
        if((colIdx + 1 < n) && (!visited[rowIdx][colIdx + 1]) && (board[rowIdx][colIdx + 1] == word.charAt(idx))) {
            boolean right = solve(board, word, rowIdx, colIdx + 1, idx + 1, m, n, visited);

            if(right) return true;
        }

        visited[rowIdx][colIdx] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        int rowIdx = 0;
        int colIdx = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    rowIdx = i;
                    colIdx = j;

                    int idx = 1;
                    if(solve(board, word, rowIdx, colIdx, idx, m, n, visited) == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }
}