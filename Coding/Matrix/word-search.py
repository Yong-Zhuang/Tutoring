class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(i, j, board, word):
                    return True
        return False

    def dfs(self, i, j, board, word):
        if len(word) == 0:
            return True
        row, col = len(board), len(board[0])
        if 0 > i or i >= row or 0 > j or j >= col or board[i][j] != word[0]:
            return False

        temp = word[0]
        board[i][j] = "@"
        res = self.dfs(i, j+1, board, word[1:]) or self.dfs(i, j-1, board, word[1:]) or self.dfs(
            i+1, j, board, word[1:]) or self.dfs(i-1, j, board, word[1:])
        board[i][j] = temp
        return res
