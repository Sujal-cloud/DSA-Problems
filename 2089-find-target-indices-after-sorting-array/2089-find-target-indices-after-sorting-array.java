class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countLessThan = 0;
        int countEqual = 0;
        
        for (int num : nums) {
            if (num < target) {
                countLessThan++;
            } else if (num == target) {
                countEqual++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < countEqual; i++) {
            ans.add(countLessThan + i);
        }
        
        return ans;
    }
}