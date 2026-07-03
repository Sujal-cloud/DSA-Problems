class Solution {
    static int countVowels(String str) {
        int cnt = 0;

        String vowels = "aeiouAEIOU";
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(vowels.indexOf(ch) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        
        StringBuilder a = new StringBuilder();
        for(int i=0; i<n/2; i++) {
            char ch = s.charAt(i);
            a.append(ch);
        }

        StringBuilder b = new StringBuilder();
        for(int i=n/2; i<n; i++) {
            char ch = s.charAt(i);
            b.append(ch);
        }

        if(countVowels(a.toString()) == countVowels(b.toString())) {
            return true;
        }
        return false;
    }
}