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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(temp != null) {
            boolean duplicate = false;
            while(temp.next != null && temp.val == temp.next.val) {
                duplicate = true;
                temp = temp.next;
            }
            if(duplicate) {
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}