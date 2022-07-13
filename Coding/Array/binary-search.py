class Solution:
    '''
    Time: O(log n)
    Space: O(1)
    '''

    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        while r >= l:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid-1
            else:
                l = mid+1
        return -1
