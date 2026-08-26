class Solution {
    public int countGoodSubstrings(String s) {
        int[] arr = new int[26];
        int k = 3;

        int left = 0;

        int cnt = 0;
        for(int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            int val = ch - 'a';
            arr[val]++;

            if(arr[val] > 1) {
                while(arr[val] > 1) {
                    char leftChar = s.charAt(left);
                    arr[leftChar - 'a']--;
                    left++;
                }
            }else{
                if(right - left +1 == k) {
                    cnt++;
                    char leftChar = s.charAt(left);
                    arr[leftChar - 'a']--;
                    left++;
                }
            }
        }
        return cnt;
    }
}