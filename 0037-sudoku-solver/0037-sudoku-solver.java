class Solution {
    static boolean findEmptyCell(char[][] board, int[] empty) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    empty[0] = i;
                    empty[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, char charVal, int rowIdx, int colIdx) {
        //1 not in same row
        for(int col=0; col<9; col++) {
            if(board[rowIdx][col] == charVal) {
                return false;
            }
        }

        //2 not in same col
        for(int row=0; row<9; row++) {
            if(board[row][colIdx] == charVal) {
                return false;
            }
        }

        //3 not in same grid
        int startRow = rowIdx - rowIdx%3;
        int startCol = colIdx - colIdx%3;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[startRow + i][startCol + j] == charVal) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean helper(char[][] board) { 
        //base case
        //if no empty cell left -> board completed
        int[] empty = new int[2];
        if(!findEmptyCell(board, empty)) {
            return true;
        }

        int rowIdx = empty[0];
        int colIdx = empty[1];

        //now put 1-9 in each cell and check if safe to place
        for(int val=1; val<=9; val++) {
            char charVal = (char)(val + '0');
            if(isSafe(board, charVal, rowIdx, colIdx)) {
                board[rowIdx][colIdx] = charVal;

                //recursive call
                if(helper(board) == true) {
                    return true;
                }

                //backtracking -> undo step
                board[rowIdx][colIdx] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}