class Solution {
public:
    int reversed(int x) {
        int digit;
        long long ans = 0;
        while(x > 0) {
            digit = x % 10;
            ans = ans * 10 + digit;

            x = x / 10;
        }
        return ans;
    }
    bool isPalindrome(int x) {
        return reversed(x) == x;
    }
};