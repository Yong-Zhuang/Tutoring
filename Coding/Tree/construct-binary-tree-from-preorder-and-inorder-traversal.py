# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def subBuildTree(stop):
            if inorder and inorder[0] != stop:
                root = TreeNode(preorder.pop(0))
                root.left = subBuildTree(root.val)
                inorder.pop(0)
                root.right = subBuildTree(stop)
                return root
        root = subBuildTree(None)
        return root
