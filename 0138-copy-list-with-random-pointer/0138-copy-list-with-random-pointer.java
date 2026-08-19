/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    static void insertBetween(Node head) {

        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    static void connectRandom(Node head) {
         Node temp = head;

         while(temp != null) {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
         }
    }

    static Node connectNext(Node head) {
        if(head == null) return null;

        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;

        while(temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null; 

        insertBetween(head);
        connectRandom(head);
       return connectNext(head);
    }
}