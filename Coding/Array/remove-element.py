class Solution:
    '''
    Time: O(n)
    Space: O(1)
    '''

    def removeElement(self, nums: List[int], val: int) -> int:
        cur = 0
        for n in nums:
            if n != val:
                nums[cur] = n
                cur += 1
        return cur
