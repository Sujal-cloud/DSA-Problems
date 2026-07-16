class Solution {
    static void solve(int k, int n, int num, int sum, List<Integer> temp, List<List<Integer>> res) {
        if(sum == n && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(num > 9) return;

        //include
        int curr = num;
        temp.add(curr);

        solve(k, n, num + 1, sum + curr, temp, res);

        //exclude
        temp.remove(temp.size() - 1);
        solve(k, n, num + 1, sum, temp, res);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int num = 1;
        int sum = 0;
        solve(k, n, num, sum, temp, res);
        return res;
    }
}