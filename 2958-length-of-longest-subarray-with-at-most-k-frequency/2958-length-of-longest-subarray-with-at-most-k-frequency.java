class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int maxLen = Integer.MIN_VALUE;

        // List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int right=0; right<n; right++) {
            int key = nums[right];

            map.put(key, map.getOrDefault(key, 0) + 1);

            while(map.get(key) > k) {
                int leftEl = nums[left];
                map.put(leftEl, map.get(leftEl) - 1);
                left++;
            }       

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}