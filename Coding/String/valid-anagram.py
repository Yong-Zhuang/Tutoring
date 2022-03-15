class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counter = collections.Counter(t)
        for i in s:
            if counter[i] <= 0:
                return False
            counter[i] -= 1
        return sum(counter.values()) == 0
