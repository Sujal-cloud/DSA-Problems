class Solution {
    public int countGoodSubstrings(String s) {
        int k = 3;
        int cnt = 0;

        for(int i=0; i<=s.length() - 3; i++) {
            Set<Character> set = new HashSet<>();

            set.add(s.charAt(i));
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));

            if(set.size() == 3) {
                cnt++;
            }
        }
        return cnt;
    }
}