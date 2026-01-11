class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int>freq;

        for(char c : magazine) {
            freq[c]++;
        }

        for(char rn : ransomNote) {
            if(freq[rn] == 0) {
                return false;
            }else{
                freq[rn]--;
            }
        }
        return true;
    }
};