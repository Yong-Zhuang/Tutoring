class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = 0
        start = 0
        loc_dic = {}
        for i in range(len(s)):
            if loc_dic.get(s[i]) is not None and start <= loc_dic[s[i]]:
                start = loc_dic[s[i]]+1
            else:
                longest = max(longest, i-start+1)
            loc_dic[s[i]] = i
        return longest
