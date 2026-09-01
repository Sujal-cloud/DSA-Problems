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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x) {
                ListNode newNode = new ListNode(temp.val);
                curr.next = newNode;
                curr = curr.next;
            }
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.val >= x) {
                ListNode newNode = new ListNode(temp.val);
                curr.next = newNode;
                curr = curr.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}