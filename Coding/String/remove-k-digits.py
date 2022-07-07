class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) <= k:
            return "0"
        stack = []
        for i in range(len(num)):
            while stack and k > 0 and stack[-1] > num[i]:
                stack.pop()
                k -= 1
            if stack or num[i] != "0":
                stack.append(num[i])
        if k > 0:
            stack = stack[:-k]
        return ''.join(stack) or "0"
