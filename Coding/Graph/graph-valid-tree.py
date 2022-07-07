# You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

# Return true if the edges of the given graph make up a valid tree, and false otherwise.


# Example 1:   (0)
#          |    |    |
#         (1)  (2)  (3)
#          |
#         (4)

# Input: n = 5, edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
# Output: true


# Example 2:
# (0)-(1)-(2)
#      | \ |
#     (4) (3)


# Input: n = 5, edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
# Output: false


# Constraints:

#     - 1 <= n <= 2000
#     - 0 <= edges.length <= 5000
#     - edges[i].length == 2
#     - 0 <= ai, bi < n
#     - ai != bi
#     - There are no self-loops or repeated edges.

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        neighbors = {i: [] for i in range(n)}
        for p, c in edges:
            neighbors[p].append(c)
            neighbors[c].append(p)
        stack = [list(neighbors.keys())[0]]
        visit = set()
        while stack:
            node = stack.pop()
            if node in visit:
                return False
            visit.add(node)
            for nb in neighbors[node]:
                stack.append(nb)
                neighbors[nb].remove(node)
        return len(visit) == n
