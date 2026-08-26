class Solution {
    static boolean matches(int[] sArr, int[] pArr) {
        for(int i=0; i<26; i++) {
            if(sArr[i] != pArr[i]) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pArr = new int[26];
        int[] sArr = new int[26];

        if(s.length() < p.length()) {
            return ans;
        }

        int k = p.length();

        for(int i=0; i<k; i++) {
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }

        if(matches(sArr, pArr)) {
            ans.add(0);
        }
        for(int i=k; i<s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;

            sArr[s.charAt(i-k) - 'a']--;

            if(matches(sArr, pArr)) {
                ans.add(i-k+1);
            }
        }
        return ans;
    }
}