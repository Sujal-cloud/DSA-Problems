class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int p = 2; p * p <= right; p++) {
            if(isPrime[p]) {
                for(int i = p * p ; i <= right; i+=p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            if(isPrime[i]) {
                res.add(i);
            }
        }

        int[] ans = {-1, -1};
        int minDiff = Integer.MAX_VALUE;

        for(int i=1; i<res.size(); i++) {
            int diff = res.get(i) - res.get(i-1);

            if(diff < minDiff) {
                minDiff = diff;
                ans[0] = res.get(i-1);
                ans[1] = res.get(i);
            }
        }
        return ans;
    }
}