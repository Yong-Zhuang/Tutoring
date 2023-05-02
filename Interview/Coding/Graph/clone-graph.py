"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        nodeDic = {}

        def dfs(node):
            if nodeDic.get(node.val) is None:
                cNode = Node(node.val)
                nodeDic[node.val] = cNode
                for c in node.neighbors:
                    cNode.neighbors.append(dfs(c))
            else:
                cNode = nodeDic[node.val]
            return cNode
        if not node:
            return None
        return dfs(node)
