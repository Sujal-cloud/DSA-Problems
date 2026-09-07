class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prefMax = new int[n];
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            maxi = Math.max(maxi, height[i]);
            prefMax[i] = maxi;
        }

        int[] suffMax = new int[n];
        maxi = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--) {
            maxi = Math.max(maxi, height[i]);
            suffMax[i] = maxi;
        }

        int total = 0;
        for(int i=0; i<n; i++) {
            total += (Math.min(prefMax[i], suffMax[i]) - height[i]);
        }
        return total;
    }
}