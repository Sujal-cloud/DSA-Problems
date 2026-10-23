class Solution {
    static void solve(char[] s, int start, int end) {
        if(start > end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        solve(s, start + 1, end - 1);
    }
    public void reverseString(char[] s) {
        int n = s.length;
        solve(s, 0, n-1);
    }
}