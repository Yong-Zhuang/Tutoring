# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def subfun(root, minimal, maximal):
            if not root:
                return
            if root.val >= maximal or root.val <= minimal:
                self.out = False
            else:
                subfun(root.left, minimal, root.val)
                if self.out:
                    subfun(root.right, root.val, maximal)
        self.out = True
        subfun(root, -inf, inf)
        return self.out
