class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minIdx = -1;
        int n = drones.length;
        int minDist = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int dist = Math.abs(x - target[0]) + Math.abs(y - target[1]);
            if(dist <= range && dist < minDist) {
                minDist = dist;
                minIdx = i;
            }
        }
        return minIdx;
        
    }
}