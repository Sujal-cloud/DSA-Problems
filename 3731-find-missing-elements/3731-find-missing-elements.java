class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num < mini) {
                mini = num;
            }
            if(num > maxi) {
                maxi = num;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num); 
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=mini; i<=maxi; i++) {
            if(!temp.contains(i)) {
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}