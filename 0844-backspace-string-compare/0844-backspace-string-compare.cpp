class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char> st1;
        string ans1;

        for(char c : s) {
            if(c != '#') {
                st1.push(c);
            }else if(c == '#' && !st1.empty()) {
                st1.pop();
            }
        }
        while(!st1.empty()) {
            ans1.push_back(st1.top());
            st1.pop();
        }

        stack<char> st2;
        string ans2;

        for(char c : t) {
            if(c != '#') {
                st2.push(c);
            }else if(c == '#' && !st2.empty()) {
                st2.pop();
            }
        }
        while(!st2.empty()) {
            ans2.push_back(st2.top());
            st2.pop();
        }

        if(ans1 == ans2){
            return true;
        }
        return false;
    }
};