class Solution {
    static boolean isValid(int[] position, int m, int mid) {
        int balls = 1;
        int lastPos = position[0];

        for(int i=1; i<position.length; i++) {
            if(position[i] - lastPos >= mid) {
                balls++;
                lastPos = position[i];
            }
        }
        return balls >= m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int s = 1;
        int e = position[n-1] - position[0];

        int ans = -1;
        while(s <= e) {
            int mid = s + (e-s)/2;
            if(isValid(position, m, mid)) {
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}