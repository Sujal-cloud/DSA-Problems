class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(res.length() != n) {
            int maxCount = 0;
            char maxChar = ' ';

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    maxChar = entry.getKey();
                }
            }
            for(int i=0; i<maxCount; i++) {
                res.append(maxChar);
            }
            map.remove(maxChar);
        }
        return res.toString();
    }
}