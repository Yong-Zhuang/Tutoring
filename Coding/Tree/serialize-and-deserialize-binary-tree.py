# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "*"
        else:
            return f"{root.val},{self.serialize(root.left)},{self.serialize(root.right)}"

    def dfs(self):
        val = self.vals.pop(0)
        if val != "*":
            node = TreeNode(val)
            node.left = self.dfs()
            node.right = self.dfs()
            return node
        else:
            return None

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data[0] == "*":
            return None
        self.vals = data.split(",")
        return self.dfs()


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
