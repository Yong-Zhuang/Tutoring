# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        if not root:
            return "#"
        else:
            return f"{root.val},{self.serialize(root.left)},{self.serialize(root.right)}"

    def dfs(self):
        val = self.vals.pop(0)
        if val == "#":
            return None
        else:
            node = TreeNode(val)
            node.left = self.dfs()
            node.right = self.dfs()
            return node

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        if data[0] == "#":
            return None
        self.vals = data.split(",")
        return self.dfs()


# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans
