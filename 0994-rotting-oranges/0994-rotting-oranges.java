class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                if(r - 1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    fresh--;
                    q.offer(new int[] {r-1, c});
                }

                if(r + 1 < rows && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    fresh--;
                    q.offer(new int[] {r+1, c});
                }
                
                if(c - 1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    fresh--;
                    q.offer(new int[] {r, c-1});
                }

                if(c + 1 < cols && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    fresh--;
                    q.offer(new int[] {r, c+1});
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}