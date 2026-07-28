class Solution {
    static char getSmallest(Map<Character, Integer> map) {
        char smallest = Character.MAX_VALUE;

        for (char ch : map.keySet()) {
            if (map.get(ch) >= 2 && ch < smallest) {
                smallest = ch;
            }
        }
        return smallest;
    }

    public String smallestPalindrome(String s) {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char[] res = new char[n];

        if (n % 2 != 0) {
            char middle = ' ';

            for (char ch : map.keySet()) {
                if (map.get(ch) % 2 != 0) {
                    middle = ch;
                    break;
                }
            }

            res[n / 2] = middle;

            map.put(middle, map.get(middle) - 1);
        }

        int i = 0;
        int j = n - 1;

        while (i < j) {
            char smallest = getSmallest(map);

            res[i] = smallest;
            res[j] = smallest;

            map.put(smallest, map.get(smallest) - 2);

            i++;
            j--;
        }

        return new String(res);
    }
}