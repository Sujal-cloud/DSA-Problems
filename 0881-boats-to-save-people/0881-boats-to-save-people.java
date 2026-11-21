class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        Arrays.sort(people);

        int left = 0;
        int right = n - 1;
        int boats = 0;
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                boats++;
                right--;
                left++;
            }else{
                boats++;
                right--;
            }
        }
        return boats;
    }
}