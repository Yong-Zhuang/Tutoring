class Solution:
    '''
    Time: O(n*n)
    Space: O(n*n)
    '''
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        matrix[:] = [list(i) for i in zip(*matrix[::-1])]

    '''
    Time: O(n*n)
    Space: O(1)
    '''

    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n//2):
            for j in range(i, n-i-1):
                matrix[i][j], matrix[j][-i-1], matrix[-i-1][-j-1], matrix[-j -
                                                                          1][i] = matrix[-j-1][i], matrix[i][j], matrix[j][-i-1], matrix[-i-1][-j-1]
