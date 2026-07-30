class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;

        int rolls = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // process all squares reachable in current number of rolls
            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                // reached destination
                if (curr == n * n) {
                    return rolls;
                }

                // try all 6 dice values
                for (int dice = 1; dice <= 6; dice++) {

                    int next = curr + dice;

                    if (next > n * n) {
                        break;
                    }

                    // convert square number -> row, col
                    int level = (next - 1) / n;
                    int row = (n - 1) - level;

                    int temp = (next - 1) % n;
                    int col;

                    if (level % 2 == 0) {
                        col = temp;
                    } else {
                        col = (n - 1) - temp;
                    }

                    // snake or ladder
                    int destination;

                    if (board[row][col] == -1) {
                        destination = next;
                    } else {
                        destination = board[row][col];
                    }

                    // don't process same square again
                    if (!visited[destination]) {
                        visited[destination] = true;
                        q.offer(destination);
                    }
                }
            }

            // finished one BFS level = one dice roll
            rolls++;
        }

        return -1;
    }
}