class Solution {
    public String removeOuterParentheses(String s) {
       Stack<Character> st = new Stack<>();
       StringBuilder sb = new StringBuilder();

       int open = 0;
       int close = 0;

       for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(ch);
                open++;
            }else{
                st.push(ch);
                close++;
            }
            
            if(open == close) {
                st.pop();

                StringBuilder temp = new StringBuilder();

                while(st.size() > 1) {
                    temp.append(st.pop());
                }

                st.pop();

                temp.reverse();
                sb.append(temp);
                open = 0;
                close = 0;
            } 
        } 
        return sb.toString();
    }
}