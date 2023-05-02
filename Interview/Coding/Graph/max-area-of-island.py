class Solution:
    '''
    Time: O(r*c)
    Space: O(r)
    '''

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        self.maxArea, self.r, self.c = 0, len(grid), len(grid[0])
        self.dircs = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        def checkIsland(i, j):
            if i < 0 or j < 0 or i >= self.r or j >= self.c or grid[i][j] != 1:
                return
            grid[i][j] = 0
            self.area += 1
            self.maxArea = max(self.maxArea, self.area)
            for p, q in self.dircs:
                checkIsland(i+p, j+q)
        for i in range(self.r):
            for j in range(self.c):
                if grid[i][j]:
                    self.area = 0
                    checkIsland(i, j)
        return self.maxArea
