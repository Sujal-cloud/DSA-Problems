class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(sTot.containsKey(charS)) {
                if(sTot.get(charS) != charT) {
                    return false;
                }
            }
            sTot.put(charS, charT);
        }

        for(int i=0; i<t.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(tTos.containsKey(charT)) {
                if(tTos.get(charT) != charS) {
                    return false;
                }
            }
            tTos.put(charT, charS);
        }
        return true;
    }
}