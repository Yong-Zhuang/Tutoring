class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        board = [[1] * n] * m
        for i in range(1, m, 1):
            for j in range(1, n, 1):
                board[i][j] = board[i - 1][j] + board[i][j - 1]
        return board[m - 1][n - 1]