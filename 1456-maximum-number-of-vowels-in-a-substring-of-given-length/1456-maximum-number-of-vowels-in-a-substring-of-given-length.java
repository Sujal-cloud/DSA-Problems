class Solution {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;

        int maxCount = 0;

        for(int i=0; i<k; i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        maxCount = vowelCount;

        for(int i=k; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
                vowelCount++;
            }

            char prev = s.charAt(i-k);
            if(prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
                vowelCount--;
            }

            maxCount = Math.max(maxCount, vowelCount);
        }
        return maxCount;
    }
}