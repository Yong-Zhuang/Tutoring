class Solution:
    def findMin(self, nums: List[int]) -> int:
        s, e = 0, len(nums)-1
        while s <= e:
            mid = (s+e)//2
            if nums[mid] < nums[e]:
                e = mid
            elif nums[mid] > nums[e]:
                s = mid+1
            else:
                return nums[e]

#Time: O(logn)
#Space: O(1)
