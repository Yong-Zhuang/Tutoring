# You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

# Return the number of connected components in the graph.


# Example 1:
#             (0) - (1)   (3)
#                    |     |
#                   (2)   (4)

# Input: n = 5, edges = [[0, 1], [1, 2], [3, 4]]
# Output: 2


# Example 2:
#             (0) - (1)   (3)
#                    |  /  |
#                   (2)   (4)


# Input: n = 5, edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
# Output: 1


# Constraints:

#     - 1 <= n <= 2000
#     - 1 <= edges.length <= 5000
#     - edges[i].length == 2
#     - 0 <= ai <= bi < n
#     - ai != bi
#     - There are no repeated edges.

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        link = list(range(n))

        def relink(i):
            if link[i] != i:
                link[i] = relink(link[i])
            return link[i]
        for s, e in edges:
            link[relink(s)] = relink(e)
        components = set()
        for i in link:
            components.add(relink(i))
        return len(components)
