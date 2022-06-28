# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack = []

        def subTraversal(root, stack):
            if not root:
                return stack
            stack = subTraversal(root.left, stack)
            stack.append(root.val)
            stack = subTraversal(root.right, stack)
            return stack
        subTraversal(root, stack)
        return stack
