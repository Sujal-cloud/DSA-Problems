class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int add = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')  {
                openCount++;
            }else{
                if(openCount > 0) {
                    openCount--;
                }else{
                    add++;
                }
            }
        }

        return openCount + add;
    }
}