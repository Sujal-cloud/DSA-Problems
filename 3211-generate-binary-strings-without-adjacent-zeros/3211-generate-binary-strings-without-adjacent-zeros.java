class Solution {
    static void solve(int n, String str, List<String> ans, int last) {
        if(n == 0) {
            ans.add(str);
            return;
        }

        solve(n-1, str + "1", ans, 1);

        if(last != 0) {
            solve(n-1, str + "0", ans, 0);
        }
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, "", ans, 1);
        return ans;
    }
}