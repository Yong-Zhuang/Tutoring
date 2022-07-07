'''
Given a linked list, odd nodes are in ascending order and even nodes are in descending order. Write a function to reorder the whole linked list in ascending order.
Example:
    input: 1->8->3->6->5->4->7->2->NULL
    output: 1->2->3->4->5->6->7->8->NULL
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reoderList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        evenHead = head.next
        odd, even = head, evenHead
        while even and even.next:
            odd.next = even.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        odd.next = None

        prev, cur = None, evenHead
        while cur:
            cur.next, prev, cur = prev, cur, cur.next

        cur1, cur2 = head, prev
        while cur1:
            next1 = cur1.next
            cur1.next = cur2
            cur1 = cur2
            cur2 = next1
        return head
