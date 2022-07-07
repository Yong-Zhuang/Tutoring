# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        cur = root
        node = None
        while k > 0:
            while cur:
                stack.append(cur)
                cur = cur.left
            node = stack.pop()
            k -= 1
            cur = node.right
        return node.val
