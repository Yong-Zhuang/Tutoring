# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        stack, result = [root], []
        l2r = 1
        while stack:
            temp = [n.val for n in stack]
            if l2r > 0:
                result.append(temp)
            else:
                result.append(temp[::-1])
            l2r *= -1
            stack = [n for r in stack for n in [r.left, r.right] if n]

        return result
