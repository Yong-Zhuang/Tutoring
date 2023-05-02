class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        dp = [[] for _ in range(n+1)]
        n_range = min(n, 10)
        for c in range(1, n_range):
            for j in range(c, n+1):
                if j == c:
                    dp[j].append([c])
                else:
                    for com in dp[j-c]:
                        if c not in com:
                            dp[j].append(com+[c])
        return [com for com in dp[n] if len(com) == k]
