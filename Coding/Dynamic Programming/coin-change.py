class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] + [float("inf")] * amount
        for v in range(1, amount + 1):
            v_c_list = []
            for c in coins:
                if v - c >= 0:
                    v_c_list.append(dp[v - c])
                else:
                    v_c_list.append(float("inf"))
            dp[v] = min(v_c_list) + 1
        if dp[amount] == float("inf"):
            return -1
        else:
            return dp[amount]
