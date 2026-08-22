class Solution {
    static int digitSum(int n) {
        int dS = 0;
        while(n != 0) {
            dS += (n % 10);
            n /= 10;
        }
        return dS;
    }
    static int digitProd(int n) {
        int dP = 1;
        while(n != 0) {
            dP *= (n % 10);
            n /= 10;
        }
        return dP;
    }

    public boolean checkDivisibility(int n) {
        int sum = digitSum(n) + digitProd(n);

        if(n % sum == 0) {
            return true;
        }
        return false;
    }
}