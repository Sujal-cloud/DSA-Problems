class Solution {
    static void solve(StringBuilder sb, int open, int closed, int n, List<String> ans) {
        if(sb.length() == 2*n) {
            ans.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');

            solve(sb, open+1, closed,n, ans);

            sb.deleteCharAt(sb.length() - 1);
        }

        if(closed < open) {
            sb.append(')');

            solve(sb, open, closed + 1, n, ans);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder(2 * n);

        solve(sb, 0, 0, n, ans);

        return ans;
    }
}