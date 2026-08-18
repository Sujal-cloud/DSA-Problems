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
    static ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                res = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                res = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null) res.next = l1;
        if(l2 != null) res.next = l2;

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = getMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middleNode.next;
        middleNode.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return merge(leftHead, rightHead);
    }
}