class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        int left=0;
        int oneCount = 0;

        for(int right=0; right<s.length(); right++) {
            if(s.charAt(right) == '1') {
                oneCount++;
            }

            while(oneCount == k) {
                int currLen = right - left + 1;
                String sub = s.substring(left, right + 1);

                if(currLen < minLen || (currLen == minLen && sub.compareTo(ans) < 0)) {
                    minLen = currLen;
                    ans = sub;
                }

                if(s.charAt(left) == '1') {
                    oneCount--;
                }
                left++;
            }
        }
        return ans;
    }
}