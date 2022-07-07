# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = deque([(root.left, root.right)])
        while queue:
            l, r = queue.popleft()
            if not l and not r:
                continue
            if not l or not r or l.val != r.val:
                return False
            else:
                queue.append((l.left, r.right))
                queue.append((l.right, r.left))
        return True
