# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return False
        else:
            isSub = self.compare(root, subRoot)
            if isSub:
                return True
            else:
                return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def compare(self, root1, root2):
        if root1 and root2:
            if root1.val != root2.val:
                return False
            else:
                return self.compare(root1.left, root2.left) and self.compare(root1.right, root2.right)
        elif root1 is None and root2 is None:
            return True
        else:
            return False
