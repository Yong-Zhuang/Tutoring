class Solution:
    def rob(self, nums: List[int]) -> int:
        prev, cur = 0, 0
        for i in nums:
            prev, cur = cur, max(prev + i, cur)
        return cur
