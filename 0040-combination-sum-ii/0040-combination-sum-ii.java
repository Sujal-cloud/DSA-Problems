class Solution {
    static void solve(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> temp) {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(idx >= candidates.length || target < 0) {
            return;
        }

        int curr = candidates[idx];
        temp.add(curr);
        solve(candidates, target - curr, idx+1, ans, temp);

        temp.remove(temp.size() - 1);

        while(idx+1 < candidates.length && candidates[idx] == candidates[idx+1]) {
            idx++;
        }
        solve(candidates, target, idx+1, ans, temp);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, target, 0, ans, temp);
        return ans;
    }
}