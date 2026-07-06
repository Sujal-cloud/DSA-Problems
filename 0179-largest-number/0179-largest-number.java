class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        //sort using custom comparator,stores in descending order
        Arrays.sort(strNums, (a,b) -> (b+a).compareTo(a+b));

        //if largest is 0 return 0
        if(strNums[0].equals("0")) {
            return "0";
        }

        //otherwise create new string and return
        StringBuilder res = new StringBuilder();
        for(String str : strNums) {
            res.append(str);
        }
        return res.toString();
    }
}