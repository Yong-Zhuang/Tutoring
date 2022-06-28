class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[grid[i][j] for j in range(n)] for i in range(m)]
        print(dp)
        for i in range(m):
            for j in range(n):
                if i == 0:
                    if j > 0:
                        dp[i][j] += dp[i][j-1]
                elif j == 0:
                    if i > 0:
                        dp[i][j] += dp[i-1][j]
                else:
                    dp[i][j] += min(dp[i][j-1], dp[i-1][j])
        return dp[m-1][n-1]
