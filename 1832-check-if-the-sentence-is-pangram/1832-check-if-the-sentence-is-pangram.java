class Solution {
    public boolean checkIfPangram(String sentence) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : sentence.toCharArray()) {
            map.put(ch, 1);
        }
        return map.size() == 26;
    }
}