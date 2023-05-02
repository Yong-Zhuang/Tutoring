class Solution:
    '''
    Time: O(log n)
    Space: O(1)
    '''

    def mySqrt(self, x: int) -> int:
        l, r = 0, x//2 + 1
        while r >= l:
            mid = (l+r)//2
            if mid*mid > x:
                r = mid-1
            else:
                l = mid+1
        return r
