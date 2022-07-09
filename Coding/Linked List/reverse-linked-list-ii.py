# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        pre = dummy
        for i in range(left-1):
            pre = pre.next
        cur = pre.next
        nex = cur.next
        for i in range(right-left):
            nex.next, cur, nex = cur, nex, nex.next
        pre.next.next = nex
        pre.next = cur
        return dummy.next
