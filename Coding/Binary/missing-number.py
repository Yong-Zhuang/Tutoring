class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        return int(n*(1+n)/2 - sum(nums))
