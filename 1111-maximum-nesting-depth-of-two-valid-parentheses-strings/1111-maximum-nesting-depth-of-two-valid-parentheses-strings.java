class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        ArrayList<Integer> ans = new ArrayList<>();

        int depth = 0;
        for(char ch : seq.toCharArray()) {
            if(ch == '(') {
                depth++;
                ans.add(depth % 2);
            }
            if(ch == ')') {
                ans.add(depth % 2);
                depth--;
            }
        }
        int n = ans.size();
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}