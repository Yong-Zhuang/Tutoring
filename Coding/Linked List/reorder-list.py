# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        prev, cur = None, slow.next
        while cur:
            cur.next, prev, cur = prev, cur, cur.next
        slow.next = None
        cur1, cur2 = head, prev
        while cur1:
            next1 = cur1.next
            cur1.next = cur2
            cur1 = cur2
            cur2 = next1
        return head
