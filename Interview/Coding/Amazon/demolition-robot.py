# Demolition Robot
# Given a matrix with values 0 (trenches), 1 (flat), and 9 (obstacle) you have to find minimum distance to reach 9 (obstacle). If not possible then return -1.
# The demolition robot must start at the top left corner of the matrix, which is always flat, and can move on block up, down, right, left.
# The demolition robot cannot enter 0 trenches and cannot leave the matrix.
# Sample Input:
# [1, 0, 0],
# [1, 0, 0],
# [1, 9, 1]]
# Sample Output: 3


import collections


class Solution:
    def bestDemolitionPath(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        adjacents = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        queue = collections.deque([(0, 0, 0)])
        while queue:
            x, y, step = queue.popleft()
            for p, q in adjacents:
                if x+p < 0 or y+q < 0 or x+p >= rows or y+q >= cols or grid[x+p][y+q] != "1":
                    continue

                if grid[x+p][y+q] == 9:
                    return step+1

                else:
                    grid[x+p][y+q] = 0
                    queue.append((x+p, y+q, step+1))

        return -1
