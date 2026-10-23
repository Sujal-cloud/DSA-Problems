class Solution {
    static void reverse(char[] s, int start, int end) {
        if(start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverse(s, start + 1, end - 1);
    }
    public String reverseStr(String s, int k) {
        int idx = 0;
        int n = s.length();

        char[] strArray = s.toCharArray();

        while(idx < n) {
            reverse(strArray, idx, Math.min(idx + k - 1, n - 1));
            idx = idx + (2*k);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<n; i++) {
            res.append(strArray[i]);
        }
        return res.toString();
    }
}