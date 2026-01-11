class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        unordered_map<char, int>mp;

        for(char c : s) {
            mp[c]++;
        }

        for(char an : t) {
            if(mp[an] == 0) {
                return false;
            }else{
                mp[an]--;
            }
        }
        return true;
    }
};