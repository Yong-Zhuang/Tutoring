class Solution:
    # backtracking
    def solveNQueens(self, n: int) -> List[List[str]]:
        def validNQueens(colstack, pstack, nstack):
            row = len(colstack)
            if row == n:
                result.append(colstack)
            else:
                for i in range(n):
                    if i not in colstack and i-row not in nstack and i+row not in pstack:
                        validNQueens(
                            colstack+[i], pstack+[i+row], nstack+[i-row])
        colstack, pstack, nstack, result = [], [], [], []
        validNQueens(colstack, pstack, nstack)
        return [["."*i+"Q"+"."*(n-i-1) for i in sol] for sol in result]