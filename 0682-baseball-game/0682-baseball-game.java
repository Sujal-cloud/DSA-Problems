class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(operations[i].equals("+")) {
                int one = arr.get(arr.size() - 2);
                int two = arr.get(arr.size() - 1);

                arr.add(one + two);
            }else if(operations[i].equals("D")) {
                int val = arr.get(arr.size() - 1);
                arr.add(val * 2);
            }else if(operations[i].equals("C")) {
                arr.remove(arr.size() - 1);
            }else{
                arr.add(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }

        return sum;
    }
}