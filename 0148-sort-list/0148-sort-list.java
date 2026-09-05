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
    ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }else{
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }

        if(l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }

        if(l2 != null) {
            res.next = l2;
                l2 = l2.next;
                res = res.next;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode right = mid.next;

        mid.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }
}