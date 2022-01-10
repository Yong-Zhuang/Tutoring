class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict = set(wordDict)
        isBreak = [True] + [False] * len(s)
        j = 0
        for i in range(1, len(s) + 1):
            for j in range(i):
                if isBreak[j] and s[j:i] in wordDict:
                    isBreak[i] = True
        return isBreak[-1]
