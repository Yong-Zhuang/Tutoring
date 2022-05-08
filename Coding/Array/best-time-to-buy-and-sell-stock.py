class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        output = 0
        start = 0
        for i in range(len(prices)):
            if prices[i] > prices[start]:
                output = max(prices[i]-prices[start], output)
            else:
                start = i
        return output
