class Solution {
    static boolean findEmptyCell(char[][] board, int[] emptyCell) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, char charVal, int rowIdx, int colIdx) {
        //check 3 rules

        //1 value not in same row
        for(int col=0; col<9; col++) {
            if(board[rowIdx][col] == charVal) {
                return false;
            }
        }

        //2 value not in same col
        for(int row=0; row<9; row++) {
            if(board[row][colIdx] == charVal) {
                return false;
            }
        }

        //3 value not in same 3*3 grid
        //find starting index for row and col and then simply 2D traverse
        int startingRow = rowIdx - rowIdx%3;
        int startingCol = colIdx - colIdx%3;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[startingRow + i][startingCol + j] == charVal) {
                    return false;
                }
            }
        }

        //if every rule checked
        return true;
    }
    static boolean helper(char[][] board) {
        //base case 
        // if no empty cell found -> board solved
        int[] emptyCell = new int[2];
        if(!findEmptyCell(board, emptyCell)) {
            return true;
        }

        //place values from 1 to 9 at empty cell and check if safe to place
        int rowIdx = emptyCell[0];
        int colIdx = emptyCell[1];

        for(int val=1; val<=9; val++) {
            char charVal = (char)(val + '0');

            if(isSafe(board, charVal, rowIdx, colIdx)) {
                board[rowIdx][colIdx] = charVal;

                //recursive call
                if(helper(board) == true) {
                    return true;
                }

                //back-tracking step for next checking undo current move
                board[rowIdx][colIdx] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}