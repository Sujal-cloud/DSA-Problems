class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        int m = nums1.length;
        int n = nums2.length;

        int[] nums3 = new int[n+m];

        int idx = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]) {
                nums3[idx] = nums1[i];
                idx++;
                i++;
            }else{
                nums3[idx] = nums2[j];
                idx++;
                j++;
            }
        }
        while(i < m) {
            nums3[idx] = nums1[i];
            idx++;
            i++;
        }
        while(j < n) {
            nums3[idx] = nums2[j];
            idx++;
            j++;
        }

        int size = nums3.length;
        double avg = -1;
        if(size % 2 == 0) {
            int mid1 = (size / 2) - 1;
            int mid2 = size / 2;

            avg = (double)(nums3[mid1] + nums3[mid2])/2.0;
        }else{
            int mid = size / 2;
            avg = (double)nums3[mid];
        }
        return avg;
    }
}