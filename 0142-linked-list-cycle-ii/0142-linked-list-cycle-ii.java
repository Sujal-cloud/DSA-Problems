/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    static ListNode floyd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return slow;
            }
        }

        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode intersection = floyd(head);

        if(intersection == null) {
            return null;
        }
        ListNode start = head;
        while(start != intersection) {
            start = start.next;
            intersection = intersection.next;
        }
        return start;
    }
}