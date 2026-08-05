class Solution {
    public int firstUniqChar(String s){
        int idx = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(map.get(ch) == 1) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}