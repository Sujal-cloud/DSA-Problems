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
    static ListNode findKthNode(ListNode head, int k) {
        k -= 1;
        while(head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if(temp == head) {
                head = kthNode;
            }
            else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}