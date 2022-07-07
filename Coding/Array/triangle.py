class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        minPath = [i for i in triangle[-1]]
        if len(triangle) == 1:
            return minPath[0]
        for l in range(len(minPath)-2, -1, -1):
            for i in range(len(triangle[l])):
                minPath[i] = min(minPath[i], minPath[i+1])+triangle[l][i]
        return minPath[0]
