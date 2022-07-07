class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        cur = -1
        for i in range(n-2, -1, -1):
            if nums[i] < nums[i+1]:
                cur = i
                break
        if cur < 0:
            nums[:] = nums[::-1]
        else:
            for i in range(n-1, -1, -1):
                if nums[cur] < nums[i]:
                    nums[cur], nums[i] = nums[i], nums[cur]
                    break
            nums[cur+1:] = nums[cur+1:][::-1]
