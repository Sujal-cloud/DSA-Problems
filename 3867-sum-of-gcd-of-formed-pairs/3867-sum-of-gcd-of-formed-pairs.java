class Solution {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        int[] prefixGrid = new int[n];
        for(int i=0; i<n; i++) {
            maxi = Math.max(nums[i], maxi);
            prefixGrid[i] = gcd(maxi, nums[i]);
        }

        Arrays.sort(prefixGrid);
        long sum = 0;
        int i=0;
        int j = n - 1;
        while(i < j) {
            int pair = gcd(prefixGrid[i], prefixGrid[j]);
            sum += pair;
            i++;
            j--;
        }
        return sum;
    }
}