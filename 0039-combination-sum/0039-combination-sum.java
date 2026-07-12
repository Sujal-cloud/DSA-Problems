class Solution {
    static void solve(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> temp) {
        if(idx >= candidates.length) {
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) {
            return;
        }
        //include
        int curr = candidates[idx];
        temp.add(curr);
        solve(candidates, target - curr, idx, ans, temp);

        //exclude
        temp.remove(temp.size() - 1);
        solve(candidates, target, idx+1, ans, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, target, 0, ans, temp);
        return ans;
    }
}