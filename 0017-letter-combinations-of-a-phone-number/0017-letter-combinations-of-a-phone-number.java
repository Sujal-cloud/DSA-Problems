class Solution {
    static void solve(String digits, int idx, StringBuilder out, List<String> ans, String[] mapping) {
        if(idx >= digits.length()) {
            ans.add(out.toString());
            return;
        }

        //curr val
        int val = digits.charAt(idx) - '0';
        //find mapped string to that val
        String mappedStr = mapping[val];

        for(int i=0; i<mappedStr.length(); i++) {
            out.append(mappedStr.charAt(i));
            solve(digits, idx+1, out, ans, mapping);

            out.deleteCharAt(out.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();
        StringBuilder out = new StringBuilder();

        int idx = 0;
        solve(digits, idx, out, ans, mapping);
        return ans;
    }
}