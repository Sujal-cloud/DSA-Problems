class Solution {
public:
    string minRemoveToMakeValid(string s) {
        string temp;
        int balance = 0;

        for(char c : s) {
            if(c == '('){
                balance++;
                temp.push_back(c);
            }else if(c == ')') {
                if(balance > 0) {
                    balance--;
                    temp.push_back(c);
                }
            }else{
                temp.push_back(c);
            }
        }

        string ans;
        for(int i=temp.size() - 1; i >= 0; i--) {
            if(temp[i] == '(' && balance > 0) {
                balance--;
            }
            else{
                ans.push_back(temp[i]);
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};