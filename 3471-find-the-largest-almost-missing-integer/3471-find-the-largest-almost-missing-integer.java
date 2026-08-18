class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //now we have freq map
        int ans = -1;
        int maxi = -1;
        if(k == 1) {
            for(int i=0; i<n; i++) {
                if(nums[i] > maxi && map.get(nums[i]) == 1) {
                    maxi = nums[i];
                    ans = maxi;
                }
            }
        }
        else if(k == n) {
            for(int i=0; i<n; i++) {
                maxi = Math.max(maxi, nums[i]);
            }
            ans = maxi;
        }
        else{
            if(map.get(nums[0]) == 1 && map.get(nums[n-1]) == 1) {
                ans = Math.max(nums[0], nums[n-1]);
            }else if(map.get(nums[0]) == 1) {
                ans = nums[0];
            }else if(map.get(nums[n-1]) == 1) {
                ans = nums[n-1];
            }
        }
        return ans;
    }
}