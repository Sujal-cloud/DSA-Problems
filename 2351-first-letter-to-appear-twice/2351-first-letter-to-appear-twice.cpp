class Solution {
public:
    char repeatedCharacter(string s) {
        unordered_map<char, int> mp;
        char ans;

        for(int i=0; i<s.length(); i++) {
            char c = s[i];

            if(mp.count(c)) {
                ans = c;
                break;
            }
            else{
                mp[c]++;
            }
        }
        return ans;
    }
};