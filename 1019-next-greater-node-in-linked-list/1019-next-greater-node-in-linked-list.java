/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.size()];

        for(int i=arr.size() - 1; i>=0; i--) {
            int curr = arr.get(i);

            while(!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }
            if(!st.isEmpty()) {
                ans[i] = st.peek();
            }else{
                ans[i] = 0;
            }

            st.push(curr);
        }
        return ans;
    }
}