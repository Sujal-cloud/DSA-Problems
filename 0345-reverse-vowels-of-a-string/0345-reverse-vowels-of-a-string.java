class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        int low = 0;
        int high = n - 1;

        while(low < high) {
            while(low < high && "AEIOUaeiou".indexOf(sb.charAt(low)) == -1) {
                low++;
            }
            while(low < high && "AEIOUaeiou".indexOf(sb.charAt(high)) == -1) {
                high--;
            }

            if(low < high) {
                char temp = sb.charAt(low);
                sb.setCharAt(low, sb.charAt(high));
                sb.setCharAt(high, temp);

                low++;
                high--;
            }
        }
        return sb.toString();
    }
}