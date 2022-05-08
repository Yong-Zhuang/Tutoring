class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] <= nums[-1]:
            return nums[0]
        elif len(nums) == 2:
            return nums[1]
        else:
            half = len(nums)//2
            if nums[half] > nums[-1]:
                return self.findMin(nums[half+1:])
            else:
                return self.findMin(nums[:half+1])
