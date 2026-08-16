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
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            //if we done have k elements
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            }

            //now we have kth node
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            //if first k group, move head to kth node
            if(temp == head) {
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}