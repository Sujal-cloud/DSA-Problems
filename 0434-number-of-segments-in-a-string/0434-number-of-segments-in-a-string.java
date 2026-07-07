class Solution {
    public int countSegments(String s) {
        int n = s.length();

        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i-1) == ' ')) {
                cnt++;
            }
        }
        return cnt;
    }
}