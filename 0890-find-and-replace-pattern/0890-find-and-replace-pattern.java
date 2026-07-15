class Solution {
    static boolean isMatch(String word, String pattern) {
        Map<Character, Character> pTow = new HashMap<>();
        Map<Character, Character> wTop = new HashMap<>();

        for(int i=0; i<word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if(!pTow.containsKey(p)) {
                pTow.put(p, w);
            }else{
                if(pTow.get(p) != w) {
                    return false;
                }
            }

            if(!wTop.containsKey(w)) {
                wTop.put(w, p);
            }
            else{
                if(wTop.get(w) != p) {
                    return false;
                }
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            if(isMatch(words[i], pattern)) {
                res.add(words[i]);
            }
        }
        return res;
    }
}