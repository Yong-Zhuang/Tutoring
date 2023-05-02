class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        start = 0
        counter = {}
        maxlen = 0
        for end in range(len(s)):
            if counter.get(s[end]) is None:
                counter[s[end]] = 1
            else:
                counter[s[end]] += 1
            maxlen = max(maxlen, counter[s[end]])
            if end - start + 1 > maxlen+k:
                counter[s[start]] -= 1
                start += 1
        return end - start + 1
