class Solution {
    static int dist(char a, char b) {
        int x = Math.abs((a - '0') - (b - '0'));
        return Math.min(x, 10 - x);
    }
    public int minRotations(String s) {
        int total = 0;
        char last = '0';

        for(char ch : s.toCharArray()) {
            total += dist(last, ch);
            last = ch;
        }

        return total;
    }
}