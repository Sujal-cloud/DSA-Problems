class Solution {
    static void solve(int[] nums, int idx, List<List<Integer>> ans, List<Integer> output) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        int curr = nums[idx];
        //include
        output.add(curr);
        solve(nums, idx+1, ans, output);

        //backtrack
        output.remove(output.size() - 1);

        //remove duplicate
        while(idx + 1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }

        //exclude
        solve(nums, idx+1, ans, output);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int idx = 0;
        solve(nums, idx, ans, output);
        return ans;
    }
}