class Solution {
    static void solve(String digits, int idx, StringBuilder output, List<String> res, String[] mapping) {
        if(idx >= digits.length()) {
            res.add(output.toString());
            return;
        }
        int val = digits.charAt(idx) - '0';
        String mappedStr = mapping[val];

        for(int i=0; i<mappedStr.length(); i++) {
            output.append(mappedStr.charAt(i));
            solve(digits, idx+1, output, res, mapping);

            //backtracking
            output.deleteCharAt(output.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> res = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        int idx = 0;

        solve(digits, idx, output, res, mapping);
        return res;
    }
}