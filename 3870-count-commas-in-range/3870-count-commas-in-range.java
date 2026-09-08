class Solution {
    static int digitsCount(int n) {
        int cntDigits = 0;
        int temp = n;
        while(temp != 0) {
            temp /= 10;
            cntDigits++;
        }

        return cntDigits;
    }
    public int countCommas(int n) {
        if(digitsCount(n) < 4) return 0;

        int commaCount = 0;

        for(int i=1; i<=n; i++) {
            if(digitsCount(i) >= 4) {
                commaCount++;
            }
        }
        return commaCount;
    }
}