class Solution {
    public int nonSpecialCount(int l, int r) {
        int limit = (int)Math.sqrt(r);

        boolean[] isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int p=2; p*p <= limit; p++) {
            if(isPrime[p]) {
                for(int i = 2*p; i<=limit; i+=p) {
                    isPrime[i] = false;
                }
            }
        }

        int cnt = 0;
        for(int i=2; i<=limit; i++) {
            if(isPrime[i] == true) {
                long num = i * i;
                if(num >= l && num <= r) {
                    cnt++;
                }
            }
        }
        return (r-l+1) - cnt;
    }
}