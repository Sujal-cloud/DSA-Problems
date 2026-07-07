class Solution {
    public static int reverseNumber(int n) {
        int reversedNum = 0;
        while (n != 0) {
            int remainder = n % 10;
            reversedNum = reversedNum * 10 + remainder;
            n /= 10;
        }
        return reversedNum;
    }
    public long sumAndMultiply(int n) {
        int x = 0;
        long sum = 0;

        while(n != 0) {
            int rem = n % 10;
            if(rem != 0){
                x = x * 10 + rem;
            }
            n /= 10;
        }
        x = reverseNumber(x);

        int temp = x;
        while(temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return x * sum;
    }
}