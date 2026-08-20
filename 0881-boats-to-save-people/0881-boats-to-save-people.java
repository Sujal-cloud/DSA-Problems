class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int cnt = 0;

        Arrays.sort(people);
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            if(people[right] + people[left] <= limit) {
                cnt++;
                right--;
                left++;
            }else{
                cnt++;
                right--;
            }
        }
        return cnt;
    }
}