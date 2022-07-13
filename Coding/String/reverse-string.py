class Solution:
    '''
    Time: O(n)
    Space: O(1)
    '''

    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l, r = 0, len(s)-1
        while r > l:
            s[l], s[r] = s[r], s[l]
            r -= 1
            l += 1
        return s
