class Solution:
    def rob(self, nums: List[int]) -> int:
        def oneWayRob(nums: List[int]):
            prev, cur = 0, 0
            for i in nums:
                prev, cur = cur, max(prev + i, cur)
            return cur

        if len(nums) == 1:
            return nums[0]
        else:
            return max(oneWayRob(nums[:-1]), oneWayRob(nums[1:]))
