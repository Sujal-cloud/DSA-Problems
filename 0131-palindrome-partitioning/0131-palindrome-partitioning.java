class Solution {
    static boolean isPalindrome(String str) {
        char[] arr = new char[str.length()];
        for(int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        int s = 0;
        int e = arr.length - 1;

        while(s < e) {
            if(arr[s] != arr[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    static void solve(String s, int idx, List<String> output, List<List<String>> ans) {
        int n = s.length();
        if(idx >= n) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int j=idx; j<n; j++) {
            String sub = s.substring(idx, j+1);
            if(isPalindrome(sub)) {
                output.add(sub);

                solve(s, j+1, output, ans);
                        

                output.remove(output.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        int idx = 0;

        solve(s, idx, output, ans);
        return ans;
    }
}