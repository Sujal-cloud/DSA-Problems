class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int num : nums) {
            if(num > 0) {
                pos.add(num);
            }else{
                neg.add(num);
            }
        }

        int[] res = new int[n];
        res[0] = pos.get(0);

        int posIdx = 1;
        for(int i=1; i<n; i++) {
            if(i % 2 == 0) {
                res[i] = pos.get(posIdx);
                posIdx++;
            }
        }

        int negIdx = 0;
        for(int i=1; i<n; i++) {
            if(i % 2 != 0) {
                res[i] = neg.get(negIdx);
                negIdx++;
            }
        }
        return res;
    }
}