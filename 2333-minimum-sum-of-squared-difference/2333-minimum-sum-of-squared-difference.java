
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        int maxDiff = 0;
        long k = (long) k1 + k2;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        if (k >= totalDiff) {
            return 0L;
        }

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                needed += Math.max(0, d - mid);
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int x = low;
        long needed = 0;
        long answer = 0;

        for (int d : diff) {
            int reduced = Math.min(d, x);
            answer += (long) reduced * reduced;
            needed += Math.max(0, d - x);
        }

        long remaining = k - needed;
        answer -= remaining * (2L * x - 1);

        return answer;
    }
}
