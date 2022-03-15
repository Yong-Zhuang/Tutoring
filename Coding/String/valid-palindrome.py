class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        i, j = 0, len(s)-1
        while j > i:
            if not (("z" >= s[i] >= "a") or ("0" <= s[i] <= "9")):
                i += 1
            elif not (("z" >= s[j] >= "a") or ("0" <= s[j] <= "9")):
                j -= 1
            else:
                if s[i] != s[j]:
                    return False
                else:
                    i += 1
                    j -= 1
        return True
