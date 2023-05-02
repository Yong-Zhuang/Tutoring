class Solution:
    '''
    Time: O(log n)
    Space: O(1)
    '''
    def isPerfectSquare(self, num: int) -> bool:
        l, r = 0, num
        while r >= l:
            mid = (l+r)//2
            if mid*mid > num:
                r = mid-1
            elif mid*mid < num:
                l = mid+1
            else:
                return True
        return False
