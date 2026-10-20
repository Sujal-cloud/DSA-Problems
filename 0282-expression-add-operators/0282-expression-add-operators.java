class Solution {
    static void solve(String num, int target, int idx, long eval, String path, long lastOperand, List<String> ans) {
        if(idx == num.length()) {
            if(eval == target) {
                ans.add(path);
            }
            return;
        }

        for(int i=idx; i<num.length(); i++) {

            if(i > idx && num.charAt(idx) == '0') break;

            String sub = num.substring(idx, i + 1);
            long currVal = Long.parseLong(sub);

            if(idx == 0) {
                solve(num, target, i+1, eval + currVal, sub, currVal, ans);
            }else{
                //try +
                solve(num, target, i+1, eval + currVal, path + "+" + sub, currVal, ans);

                //try -
                solve(num, target, i+1, eval - currVal, path + "-" + sub, -currVal, ans);

                //try *
                solve(num, target, i+1, (eval - lastOperand) + (lastOperand * currVal), path + "*" + sub, lastOperand*currVal, ans);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        int idx = 0;

        if(num == null || num.length() == 0) {
            return ans;
        }

        long eval = 0;
        String path = "";
        long lastOperand = 0;
        solve(num, target, idx, eval, path, lastOperand, ans);
        return ans;
    }
}