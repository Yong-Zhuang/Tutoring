class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        largest, temp = -inf, 0
        for i in nums:
            temp += i
            largest = max(largest, temp)
            if temp < 0:
                temp = 0
        return largest

#Time: O(n)
#Space: O(1)
