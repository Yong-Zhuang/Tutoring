class Solution:
    # Time: O((n!/k!)*n*k)

    def combine(self, n, k):
        combs = [[]]
        for _ in range(k):
            combs = [
                [i] + c for c in combs for i in range(1, c[0] if c else n+1)]
        return combs

    # Time: O((n+k)*n!/k!)
    # Space: O(k*n*n!/k!)
    def combine(self, n: int, k: int) -> List[List[int]]:
        memo = {}

        def dp(n, k, memo):
            if k == 1:
                memo[(k, n)] = [[i] for i in range(1, n+1)]
            elif k == n:
                memo[(k, n)] = [[i for i in range(1, n+1)]]
            elif memo.get((k, n)) is None:
                memo[(k, n)] = []
                nsub1 = dp(n-1, k, memo)
                nsub1ksub1 = dp(n-1, k-1, memo)
                for it in nsub1ksub1:
                    memo[(k, n)].append(it+[n])
                memo[(k, n)] += nsub1
            return memo[(k, n)]
        return dp(n, k, memo)

    # Time: O((n+k)*n!/k!)
    # Space: O(n!/k!)
    def combine(self, n, k):
        if k == 1:
            return [[i] for i in range(1, n+1)]
        elif k == n:
            return [[i for i in range(1, n+1)]]
        else:
            rs = []
            rs += self.combine(n-1, k)
            part = self.combine(n-1, k-1)
            for ls in part:
                ls.append(n)
            rs += part
            return rs
