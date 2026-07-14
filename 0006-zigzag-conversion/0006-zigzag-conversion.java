class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean down = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb[currRow].append(ch);

            if (currRow == 0 || currRow == numRows - 1) {
                down = !down;
            }
            currRow += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : sb) {
            result.append(row);
        }

        return result.toString();
    }
}