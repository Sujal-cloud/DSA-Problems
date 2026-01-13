class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()) return false;

        vector<int> freq1(26,0);        
        for(char c : s1) {
            freq1[c - 'a']++;
        }

        vector<int> freq2(26,0);
        for(int i=0; i<s1.length(); i++) {
            freq2[s2[i] - 'a']++;
        }
        if(freq1 == freq2) {
            return true;
        }
        int k = s1.length();
        for(int i=k; i<s2.length(); i++) {
            freq2[s2[i] - 'a']++;
            freq2[s2[i-k] - 'a']--;

            if(freq1 == freq2) return true;
        }
        return false;
    }
};