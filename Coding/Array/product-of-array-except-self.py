class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l = len(nums)
        arr, left, right = [1]*l, 1, 1
        for i in range(l):
            arr[i] *= left
            arr[l-i-1] *= right
            left *= nums[i]
            right *= nums[l-i-1]
        return arr

#Time: O(n)
#Space: O(n)
