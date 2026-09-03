class Solution {
    public boolean uniformArray(int[] nums1) {
        int mini = Integer.MAX_VALUE;
        int evenCount = 0;

        for(int num : nums1) {
            mini = Math.min(num, mini);
            if(num % 2 == 0) {
                evenCount++;
            }
        }

        if(mini % 2 != 0) return true;
        else{
            if(evenCount == nums1.length) return true;
        }
        return false;
    }
}