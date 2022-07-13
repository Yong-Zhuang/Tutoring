class Solution:
    '''
    Time: O(n)
    Space: O(1)
    '''
    def removeDuplicates(self, nums: List[int]) -> int:
        cur = 0
        target = None
        for n in nums:
            if n != target:
                nums[cur] = target = n
                cur += 1
        return cur
