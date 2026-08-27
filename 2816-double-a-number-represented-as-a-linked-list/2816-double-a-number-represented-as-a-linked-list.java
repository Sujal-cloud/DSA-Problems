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
    static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        int carry = 0;

        while(temp != null) {
            int product = temp.val * 2;

            temp.val = (product % 10) + carry;
            carry = product / 10;

            if(temp.next == null && carry > 0) {
                temp.next = new ListNode(carry);
                break;
            }
            temp = temp.next;
        }
        head = reverse(head);
        return head;
    }
}