class Solution {
    public int minimumLength(String s) {
        int len = s.length();

        if(len == 1) return len;
        int i=0;
        int j=len - 1;

        while(i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);

            while(i <= j && s.charAt(i) == ch) {
                i++;
            }
            while(i <= j && s.charAt(j) == ch) {
                j--;
            }
        }
        return j - i + 1;
    }
}