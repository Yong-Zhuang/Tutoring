class Solution:
    def climbStairs(self, n: int) -> int:
        cur, next = 1, 1
        for _ in range(n):
            cur, next = next, cur + next
        return cur

#Time: O(n)
#Space: O(1)
