class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLength = 0;
        unordered_set<char> window;

        while(right < n) {
            if(!window.count(s[right])) {
                window.insert(s[right]);
                right++;

                maxLength = max(maxLength, right - left);
            }else {
                while(window.count(s[right])) {
                    window.erase(s[left]);
                    left++;
                }
            }
        }
        return maxLength;
    }
};