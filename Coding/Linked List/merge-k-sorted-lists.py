# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from queue import PriorityQueue


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(None)
        cur = dummy
        q = PriorityQueue()
        for i, node in enumerate(lists):
            if node:
                q.put((node.val, i, node))
        while not q.empty():
            val, i, node = q.get()
            cur.next = ListNode(val)
            cur = cur.next
            node = node.next
            if node:
                q.put((node.val, i, node))
        return dummy.next
