class Solution {
    static boolean matches(int[] sCounts, int[] pCounts) {
        for(int i=0; i<26; i++) {
            if(sCounts[i] != pCounts[i]) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) {
            return ans;
        }
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        int k = p.length();
        for(int i=0; i<k; i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }

        //first window
        if(matches(sCounts, pCounts)) {
            ans.add(0);
        }

        for(int i=k; i<s.length(); i++) {
            // add current char
            sCounts[s.charAt(i) - 'a']++;

            //remove leftmost char
            sCounts[s.charAt(i-k) - 'a']--;

            //check if matches
            if(matches(sCounts, pCounts)) {
                ans.add(i-k+1);
            }
        }
        return ans;
    }
}