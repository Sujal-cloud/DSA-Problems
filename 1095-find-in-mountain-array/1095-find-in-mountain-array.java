class Solution {
    private int search(MountainArray mountainArr, int s, int e, int target, boolean isAscending) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            }

            if (isAscending) {
                if (val < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (val > target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    private int peakElement(MountainArray mountainArr) {
        int n = mountainArr.length();
        int s = 0;
        int e = n - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakElement = peakElement(mountainArr);
        int n = mountainArr.length();

        int left = search(mountainArr, 0, peakElement, target, true);
        if (left != -1) return left;

        int right = search(mountainArr, peakElement + 1, n - 1, target, false);
        return right;
    }
}