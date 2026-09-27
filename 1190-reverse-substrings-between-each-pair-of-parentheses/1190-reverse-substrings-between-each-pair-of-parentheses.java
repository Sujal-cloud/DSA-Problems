class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                StringBuilder temp = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '(') {
                    temp.append(st.pop());
                }

                st.pop(); // remove '('

                // Put reversed characters back individually
                for (int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }

            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();

        // Read stack bottom → top
        for (char c : st) {
            ans.append(c);
        }

        return ans.toString();
    }
}