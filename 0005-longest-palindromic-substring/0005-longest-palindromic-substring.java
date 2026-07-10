class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i=0; i<s.length(); i++) {
            //for odd
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String odd = s.substring(left+1, right);
            if(odd.length() > res.length()) {
                res = odd;
            }

            //for even
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String even = s.substring(left+1, right);
            if(even.length() > res.length()) {
                res = even;
            }
        }
        return res;
    }
}