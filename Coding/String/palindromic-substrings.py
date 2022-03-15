class Solution:
    def countSubstrings(self, s: str) -> int:
        def checkPalindromic(s: str, l: int, r: int):
            count = 0
            while l >= 0 and r < len(s) and s[l] == s[r]:
                count += 1
                l -= 1
                r += 1
            return count
        total_count = 0
        for i in range(len(s)):
            total_count += checkPalindromic(s, i, i)
            total_count += checkPalindromic(s, i, i+1)
        return total_count
