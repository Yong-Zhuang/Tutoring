class Solution:
    '''
    Time: O(n*n)
    Space: O(n)
    '''

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row, col, block = set(), set(), set()
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                r = (i, board[i][j])
                c = (j, board[i][j])
                b = (i//3, j//3, board[i][j])
                if r in row or c in col or b in block:
                    return False
                row.add(r)
                col.add(c)
                block.add(b)
        return True