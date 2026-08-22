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

        ListNode newHead = reverse(head.next);
        ListNode first = head.next;
        first.next = head;
        head.next = null;

        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        newHead = reverse(newHead);

        ListNode one = head;
        ListNode two = newHead;

        while(two != null) {
            if(one.val != two.val) {
                reverse(newHead);
                return false;
            }
            one = one.next;
            two = two.next;
        }
        reverse(newHead);
        return true;
    }
}