class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        adjacents = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def dfs(i, j):
            if i < 0 or j < 0 or i >= rows or j >= cols or grid[i][j] != "1":
                return 0
            grid[i][j] = 0
            for p, q in adjacents:
                dfs(i+p, j+q)
            return 1
        count = 0
        for i in range(rows):
            for j in range(cols):
                count += dfs(i, j)
        return count
