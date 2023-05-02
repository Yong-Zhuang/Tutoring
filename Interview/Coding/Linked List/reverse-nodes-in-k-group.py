# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        length = 0
        cur = head
        while cur:
            length += 1
            cur = cur.next
        loops = length//k
        dummy = ListNode()
        dummy.next = cur = head
        before = dummy
        for i in range(loops):
            prev, first = None, cur
            for j in range(k):
                cur.next, prev, cur = prev, cur, cur.next
            before.next = prev
            before = first
        before.next = cur
        return dummy.next
