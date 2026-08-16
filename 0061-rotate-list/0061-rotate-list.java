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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        if(k == 0) return head;

        //Now we have Node tail at last
        tail.next = head;

        //now circular link is made
        //traverse till length - 1 node
        ListNode temp = head;
        int cnt = 1;
        while(temp != null) {
            if(cnt == (len - k)) {
                break;
            }
            cnt++;
            temp = temp.next;
        }

        //now we are at len - k node, update head and break link
        head = temp.next;
        temp.next = null;

        return head;
    }
}