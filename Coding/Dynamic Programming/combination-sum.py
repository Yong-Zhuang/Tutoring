class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dp(candidates, target, memo={}):
            if target == 0:
                return [[]]
            if target < 0:
                return []
            if memo.get(target) is None:
                result = []
                for c in candidates:
                    remaind = target - c
                    remaind_com = dp(candidates, remaind, memo)
                    if remaind_com is not None:
                        for i in remaind_com:
                            comb = sorted()
                            if comb not in result:
                                result += [i+[c]]
                memo[target] = result
            return memo[target]
        return dp(candidates, target)

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        dp = [[] for _ in range(target+1)]
        dp[0] = [[]]
        for i in range(target+1):
            for j in candidates:
                for t in dp[i]:
                    if i+j <= target:
                        com = sorted(t+[j])
                        if com not in dp[i+j]:
                            dp[i+j].append(com)
        return dp[target]

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        dp = [[] for _ in range(target + 1)]
        for c in candidates:
            for i in range(c, target + 1):
                if i == c:
                    dp[i].append([c])
                else:
                    for comb in dp[i - c]:
                        dp[i].append(comb + [c])
        return dp[target]
