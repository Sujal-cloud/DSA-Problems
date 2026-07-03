class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        HashSet<Character> set = new HashSet<>();

        for(char c : allowed.toCharArray()) {
            set.add(c);
        }

        int cnt = 0;
        for(int i=0; i<words.length; i++) {
            int j=0;

            for(j=0; j<words[i].length(); j++) {
                if(set.contains(words[i].charAt(j))) {
                    continue;
                }else{
                    break;
                }
            }
            if(j == words[i].length()) {
                cnt++;
            }
        }
        return cnt;
    }
}