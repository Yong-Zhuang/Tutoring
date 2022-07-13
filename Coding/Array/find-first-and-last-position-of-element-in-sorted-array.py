class Solution:
    '''
    Time: O(log n)
    Space: O(1)
    '''

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums)-1
        while r >= l:
            mid = (l+r)//2
            if nums[mid] >= target:
                r = mid-1
            else:
                l = mid+1
        s = l
        e = len(nums)-1
        while e >= l:
            mid = (l+e)//2
            if nums[mid] > target:
                e = mid-1
            else:
                l = mid+1
        return [s, e] if e >= s else[-1, -1]
