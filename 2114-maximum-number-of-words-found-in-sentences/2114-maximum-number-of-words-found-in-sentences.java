class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String s : sentences) {
            int words = s.split(" ").length;
            ans = Math.max(ans, words);
        }
        return ans;
    }
}