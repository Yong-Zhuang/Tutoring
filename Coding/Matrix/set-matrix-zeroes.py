class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        fr, fc, m, n = False, False, len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    matrix[0][j] = matrix[i][0] = 0
                    if i == 0:
                        fr = True
                    if j == 0:
                        fc = True
        for i in range(1, m):
            for j in range(1, n):
                if matrix[0][j] == 0 or matrix[i][0] == 0:
                    matrix[i][j] = 0

        if fc:
            for i in range(m):
                matrix[i][0] = 0
        if fr:
            matrix[0] = [0]*n

        return matrix
