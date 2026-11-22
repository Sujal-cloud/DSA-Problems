class Solution {
    public boolean checkString(String s) {
        boolean flag = true;

        for(char ch : s.toCharArray()) {
            if(ch == 'a' && flag == false) {
                return false;
            }
            if(ch == 'b') {
                flag = false;
            }
        }
        return true;
    }
}