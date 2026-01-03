/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == nullptr || head->next == nullptr || k == 0) {
            return head;
        }
        ListNode* temp = head;
        int len = 1;

        while(temp->next != nullptr) {
            temp = temp -> next;
            len++;
        }
        ListNode* tail = temp;
        tail->next = head;

        k = k % len;
        temp = head;
        int count = 0;
        int limit = len - k - 1;
        while(count < limit) {
            temp = temp -> next;
            count++;
        }

        ListNode* newTail = temp;
        ListNode* newHead = newTail -> next;
        newTail -> next = nullptr;

        return newHead;
    }
};