class Solution:

    # Brute Force
    # Time: O(2^n)
    # Space: O(n)
    def fib(self, n: int) -> int:
        if n == 0:
            return 0
        elif n == 1:
            return 1
        else:
            return self.fib(n-1)+self.fib(n-2)

    # Dynamic Programming: Memoization
    # Time: O(n)
    # Space: O(n)
    def fib(self, n: int) -> int:
        def dp(n, memo={0: 0, 1: 1}):
            if memo.get(n) is None:
                memo[n] = dp(n-1, memo)+dp(n-2, memo)
            return memo[n]
        return dp(n)

    # Dynamic Programming: Tabulation
    # Time: O(n)
    # Space: O(n)

    def fib(self, n: int) -> int:
        if n == 0:
            return 0
        table = [0]*(n+1)
        table[1] = 1
        for i in range(n):
            table[i+1] += table[i]
            if i+2 <= n:
                table[i+2] += table[i]
        return table[n]

    # Time: O(n)
    # Space: O(1)
    def fib(self, n: int) -> int:
        cur, next = 0, 1
        for _ in range(n):
            cur, next = next, cur + next
        return cur
