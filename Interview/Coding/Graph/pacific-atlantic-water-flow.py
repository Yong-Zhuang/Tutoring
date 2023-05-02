class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        pacific_visited, atlantic_visited = {}, {}
        direction = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        rows, cols = len(heights), len(heights[0])

        def dfs(i, j, visited):
            if visited.get((i, j)) is None:
                visited[(i, j)] = 1
                for p, q in direction:
                    if 0 <= i+p < rows and 0 <= j+q < cols:
                        if heights[i+p][j+q] >= heights[i][j]:
                            dfs(i+p, j+q, visited)
        for i in range(rows):
            dfs(i, 0, pacific_visited)
            dfs(i, cols-1, atlantic_visited)
        for j in range(cols):
            dfs(0, j, pacific_visited)
            dfs(rows-1, j, atlantic_visited)
        outputs = []
        for (i, j) in pacific_visited:
            if atlantic_visited.get((i, j)) is not None:
                outputs.append([i, j])
        return outputs
