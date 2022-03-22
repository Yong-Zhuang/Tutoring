# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxPath = -inf
        def maxGain(node):
            if node is None:
                return 0
            left = max(maxGain(node.left),0)
            right = max(maxGain(node.right),0)
            curPath = node.val+left+right
            self.maxPath = max(self.maxPath, curPath)
            return node.val+max(left, right)
        maxGain(root)
        return self.maxPath