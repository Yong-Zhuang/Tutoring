class Solution:
    '''
    Time: O(n)
    Space: O(n)
    '''

    def replaceSpace(self, s: str) -> str:
        result = ""
        for l in s:
            if l != " ":
                result += l
            else:
                result += "%20"
        return result
