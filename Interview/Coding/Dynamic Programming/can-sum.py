# Say that you are a traveler on a 2D grid. You begin in the top-left corner and you goal is to travel to the bottom-right
# corner. You may only move down or right.

# Return the number of ways you can travel to the goal on a grid with dimensions m*n.


# Example 1:

# Input: m = 1, n= 1
# Output: 1


# Example 2:

# Input: m = 2, n= 3
# Output: 3


# Example 3:

# Input: m = 3, n= 2
# Output: 3


# Example 4:

# Input: m = 3, n= 3
# Output: 6


# Example 5:

# Input: m = 18, n= 18
# Output: 2333606220

class Solution:

    # Brute Force
    # Time: O(2^(n+m))
    # Space: O(n+m)

    def canSum(self, m: int, n: int) -> int:
        if m == 1 and n == 1:
            return 1
        elif m == 0 and n == 0:
            return 0
        else:
            return self.canSum(m-1, n)+self.canSum(m, n-1)

    # Dynamic Programming: Memoization
    # Time: O(m*n)
    # Space: O(m+n)

    def canSum(self, m: int, n: int) -> int:
        def dp(m, n, memo={(0, 0): 0, (1, 1): 1}):
            if memo.get((m, n)) is None:
                memo[(m, n)] = self.canSum(
                    m-1, n, memo)+self.canSum(m, n-1, memo)
            return memo[(m, n)]
        return dp(m, n)

    # Dynamic Programming: Tabulation
    # Time: O(m*n)
    # Space: O(m*n)

    def canSum(self, m: int, n: int) -> int:
        table = [[0]*(n+1) for _ in range(m+1)]
        table[1][1] = 1
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j+1 <= n:
                    table[i][j+1] += table[i][j]
                if i+1 <= m:
                    table[i+1][j] += table[i][j]
        return table[m][n]
