class Solution {
    static int digitSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int originalNum = nums[i];
            int sum = digitSum(originalNum);
            
            if (!treeMap.containsKey(sum)) {
                treeMap.put(sum, new ArrayList<>());
            }
            treeMap.get(sum).add(originalNum);
        }

        int[] sortedNums = new int[n];
        int index = 0;
        for (List<Integer> bucket : treeMap.values()) {
            Collections.sort(bucket); 
            for (int num : bucket) {
                sortedNums[index++] = num;
            }
        }

        Map<Integer, Queue<Integer>> targetIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!targetIndices.containsKey(sortedNums[i])) {
                targetIndices.put(sortedNums[i], new LinkedList<>());
            }
            targetIndices.get(sortedNums[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == sortedNums[i]) {
                if (nums[i] == sortedNums[i]) {
                    targetIndices.get(nums[i]).poll();
                }
                continue;
            }

            int cycleSize = 0;
            int currIndex = i;

            while (!visited[currIndex]) {
                visited[currIndex] = true;
                int targetIndex = targetIndices.get(nums[currIndex]).poll();
                currIndex = targetIndex;
                cycleSize++;
            }

            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
}
