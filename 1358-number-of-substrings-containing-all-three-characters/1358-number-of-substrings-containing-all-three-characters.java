class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        int countA = 0;
        int countB = 0;
        int countC = 0;

        int left = 0;
        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if(ch == 'a') countA++;
            else if(ch == 'b') countB++;
            else if(ch == 'c') countC++;


            while(countA >= 1 && countB >= 1 && countC >= 1) {
                cnt += n - right;
                char leftChar = s.charAt(left);

                if(leftChar == 'a') countA--;
                else if(leftChar == 'b') countB--;
                else if(leftChar == 'c') countC--;

                left++;
            }
        }
        return cnt;
    }
}