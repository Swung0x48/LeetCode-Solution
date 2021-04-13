class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        auto *head = l2;

        ListNode *last;
        for (; l1 != nullptr && l2 != nullptr; l1 = l1->next, l2 = l2->next) {
            l2->val = l1->val + l2->val;
            if (l2->val >= 10) {
                if (l2->next == nullptr)
                    l2->next = new ListNode(1);
                else
                    l2->next->val += 1;

                l2->val -= 10;
            }

            if (l2->next == nullptr)
                last = l2;
        }

        if (l1 != nullptr)
            last->next = l1;

        for (; l2 != nullptr; l2 = l2->next) {
            if (l2->val >= 10) {
                if (l2->next != nullptr) {
                    l2->next->val += 1;
                } else {
                    l2->next = new ListNode(1);
                }

                l2->val -= 10;
            } else
                break;
        }

        return head;
    }
};