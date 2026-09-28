class Solution {
    public int maxDepth(String s) {
        int ans = Integer.MIN_VALUE;

        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            }
            if(ch == ')') {
                ans = Math.max(ans, st.size());
                st.pop();
            }
        }
        if(ans == Integer.MIN_VALUE) {
            return 0;
        }
        return ans;
    }
}