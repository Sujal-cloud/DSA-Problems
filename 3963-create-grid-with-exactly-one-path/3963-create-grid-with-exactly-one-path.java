class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        char[] row = new char[n];

        for(int i=0; i<n; ++i) {
            row[i] = '#';
        }

        for(int j=0; j<m; ++j) {
            grid[j] = new String(row);
        }

        char[] first = grid[0].toCharArray();
        for(int i=0; i<n; ++i) {
            first[i] = '.';
        }
        grid[0] = new String(first);

        for(int j=0; j<m; ++j) {
            char[] r = grid[j].toCharArray();
            r[n-1] = '.';
            grid[j] = new String(r);
        }
        return grid;
    }
}