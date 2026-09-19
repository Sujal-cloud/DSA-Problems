class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int ast : asteroids) {
            boolean exploded = false;

            while(!st.isEmpty() && st.peek() > 0 && ast < 0) {
                //if stack top is less than asteroid
                if(st.peek() < -ast) {
                    st.pop();
                }
                else if(st.peek() == -ast) {
                    st.pop();
                    exploded = true;
                    break;
                }else{ // asteroid is smaller
                    exploded = true;
                    break;
                }
            }

            if(!exploded) {
                st.push(ast);
            }
        }

        int[] res = new int[st.size()];

        for(int i=st.size() - 1; i>=0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}