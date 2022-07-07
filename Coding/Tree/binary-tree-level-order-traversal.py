# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result, cur_level = [], [root]
        while cur_level:
            result.append([n.val for n in cur_level])
            lrs = [(n.left, n.right) for n in cur_level]
            cur_level = [n for lr in lrs for n in lr if n is not None]
        return result
