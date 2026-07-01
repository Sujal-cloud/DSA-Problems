class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        //now we have mapping of each even number => freq.
        int maxFreq = 0;
        int maxEven = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxFreq || (entry.getValue() == maxFreq && entry.getKey() < maxEven)) {
                maxFreq = entry.getValue();
                maxEven = entry.getKey();
            }
        }
        return maxEven;
    }
}