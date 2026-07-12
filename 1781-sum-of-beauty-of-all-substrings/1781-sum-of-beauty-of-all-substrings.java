class Solution {
    public int beautySum(String s) {
        int beauty = 0;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for(int k=0; k<26; k++) {
                    int cnt = freq[k];

                    if(cnt > 0) {
                        if(cnt > maxi) {
                            maxi = cnt;
                        }
                        if(cnt < mini) {
                            mini = cnt;
                        }
                    }
                }
                beauty += (maxi - mini);
            }
        }
        return beauty;
    }
}