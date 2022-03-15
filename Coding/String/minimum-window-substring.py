class Solution:
    def minWindow(self, s: str, t: str) -> str:
        counter = collections.Counter(t)
        missing = len(t)
        start, end, i = 0, 0, 0
        for j, v in enumerate(s, 1):
            if counter[v] > 0:
                missing -= 1
            counter[v] -= 1
            if missing == 0:
                while i < j and counter[s[i]] < 0:
                    counter[s[i]] += 1
                    i += 1
                counter[s[i]] += 1
                missing += 1
                if end == 0 or j-i < end-start:
                    start, end = i, j
                i += 1
        return s[start:end]
