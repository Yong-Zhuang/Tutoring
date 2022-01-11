# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        length = 0
        cur = head
        while cur:
            length += 1
            cur = cur.next
        idx = length - n
        i = 0
        pre, cur = None, head
        while i < idx:
            i += 1
            pre = cur
            cur = cur.next
        if pre:
            pre.next = cur.next
            return head
        elif cur.next:
            return cur.next
        else:
            return None
