class Solution:
    '''
    Time: O(n)
    Space: O(n)
    '''

    def reverseStr(self, s: str, k: int) -> str:
        result = ""
        flag = 1
        for f in range(0, len(s), k):
            e = min(f+k, len(s))
            if flag > 0:
                result = s[f:e][::-1]
            else:
                result += s[f:e]
            flag *= -1
        return result
