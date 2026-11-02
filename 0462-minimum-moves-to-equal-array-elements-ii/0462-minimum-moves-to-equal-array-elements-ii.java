class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;


        Arrays.sort(nums);
        int x = nums[n/2];
 
        int moves = 0;
        for(int num : nums) {
            moves += Math.abs(num - x);
        }
        return moves;
    }
}