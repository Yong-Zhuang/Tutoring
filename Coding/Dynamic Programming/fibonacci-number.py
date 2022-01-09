class Solution:
    def fib(self, n: int) -> int:
        cur, next = 0, 1
        for _ in range(n):
            cur, next = next, cur+next
        return cur