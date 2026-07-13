class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";

        List<Integer> res = new ArrayList<>();
        for(int len = 2; len < 10; len++) {
            for(int start = 0; start <= str.length() - len; start++) {
                int num = Integer.parseInt(str.substring(start, start + len));
                if(num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}