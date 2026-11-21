class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int[] newParent = parent.clone();
        char[] chars = s.toCharArray();

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0, -1});

        while (!stack.isEmpty()) {
            int[] state = stack.pop();
            int node = state[0];
            int type = state[1];
            int previous = state[2];
            int ch = chars[node] - 'a';

            if (type == 0) {
                if (lastSeen[ch] != -1) {
                    newParent[node] = lastSeen[ch];
                }

                stack.push(new int[]{node, 1, lastSeen[ch]});
                lastSeen[ch] = node;

                for (int child : tree[node]) {
                    stack.push(new int[]{child, 0, -1});
                }
            } else {
                lastSeen[ch] = previous;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        List<Integer>[] finalTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        int count = 0;
        Deque<Integer> nodes = new ArrayDeque<>();
        nodes.push(0);

        while (!nodes.isEmpty()) {
            int node = nodes.pop();
            order[count++] = node;

            for (int child : finalTree[node]) {
                nodes.push(child);
            }
        }

        for (int i = count - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
