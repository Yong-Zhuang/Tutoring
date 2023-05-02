class Solution:
    '''
    Time: O(n)
    Space: O(n)
    '''

    def sortedSquares(self, nums: List[int]) -> List[int]:
        l, r = 0, len(nums)-1
        result = []
        while r >= l:
            if nums[l]*nums[l] > nums[r]*nums[r]:
                result.append(nums[l]*nums[l])
                l += 1
            else:
                result.append(nums[r]*nums[r])
                r -= 1
        return result[::-1]
