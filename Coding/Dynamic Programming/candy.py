class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        stack = [1]*n
        for i in range(1, n):
            if ratings[i] > ratings[i-1]:
                stack[i] = stack[i-1]+1
        for i in range(n-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                stack[i] = max(stack[i+1]+1, stack[i])
        return sum(stack)
