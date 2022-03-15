class Solution:
    def longestPalindrome(self, s: str) -> str:
        def checkPalindrome(s: str, l: int, r: int) -> str:
            while l >= 0 and r <= len(s)-1 and s[l] == s[r]:
                l -= 1
                r += 1
            return s[l+1:r]
        longest = ""
        for i in range(len(s)):
            temp = checkPalindrome(s, i, i)
            if len(longest) < len(temp):
                longest = temp
            temp = checkPalindrome(s, i, i+1)
            if len(longest) < len(temp):
                longest = temp
        return longest
