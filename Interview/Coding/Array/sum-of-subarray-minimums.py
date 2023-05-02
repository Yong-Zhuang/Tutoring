class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        ssm = 0
        stack = []
        arr = [-inf]+arr+[-inf]
        for i, v in enumerate(arr):
            while stack and arr[stack[-1]] > v:
                indx = stack.pop()
                ssm += arr[indx]*(i-indx)*(indx-stack[-1])
            stack.append(i)
        return ssm % (10**9+7)
