class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = {}
        for i in range(len(s)):
            if dic.get(s[i]) is not None:
                dic[s[i]] = -1
            else:
                dic[s[i]] = i

        for k, v in dic.items():
            if v > -1:
                return v
        return -1
