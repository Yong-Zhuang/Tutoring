class Solution:
    def getFactors(self, n: int) -> List[List[int]]:
        stack = [(n, 2, [])]
        result = []
        while stack:
            m, f, p = stack.pop()
            while f*f <= m:
                if m % f == 0:
                    result.append(p+[int(m/f), f])
                    stack.append((int(m/f), f, p+[f]))
                f += 1
        return result
