class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0])
                                      .thenComparingInt(a -> a[1]));

        int maxWidth = 0;
        int minIdx = arr[0][1];

        for(int i=0; i<n; i++) {
            maxWidth = Math.max(maxWidth, arr[i][1] - minIdx);
            minIdx = Math.min(minIdx, arr[i][1]);
        }
        return maxWidth;
    }
}