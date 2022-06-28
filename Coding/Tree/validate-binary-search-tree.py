# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(root, minval, maxval):
            if not root.left and not root.right:
                return minval < root.val < maxval
            else:
                left, right = True, True
                if root.left:
                    left = root.val > root.left.val and dfs(
                        root.left, minval, root.val)
                if root.right:
                    right = root.val < root.right.val and dfs(
                        root.right, root.val, maxval)
                return left and right
        return dfs(root, -inf, inf)
