class Solution:
    def orderlyQueue(self, s: str, k: int) -> str:
        if k > 1:
            return "".join(sorted(s))
        else:
            s2 = s+s
            n = len(s)
            ordered = s
            for i in range(n):
                ordered = min(ordered, s2[i:n+i])
            return ordered
