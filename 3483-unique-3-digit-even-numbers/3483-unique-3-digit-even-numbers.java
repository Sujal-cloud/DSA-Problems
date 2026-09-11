class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits) {
            freq[d]++;
        }

        int cnt = 0;
        for(int i=100; i<=998; i+=2) {
            int d1 = i/100;
            int d2 = (i/10)%10;
            int d3 = i % 10;

            int[] need = new int[10];
            need[d1]++;
            need[d2]++;
            need[d3]++;

            if(freq[d1] >= need[d1] &&
                freq[d2] >= need[d2] &&
                freq[d3] >= need[d3]
            ) {
                cnt++;
            }
        }
        return cnt;
    }
}