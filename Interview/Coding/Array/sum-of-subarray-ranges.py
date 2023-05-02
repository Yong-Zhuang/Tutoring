class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        stack, ssr = [], 0
        nums = [-inf]+nums+[-inf]
        for i, v in enumerate(nums):
            while stack and nums[stack[-1]] > v:
                idx = stack.pop()
                ssr -= nums[idx]*(idx-stack[-1])*(i-idx)
            stack.append(i)
        stack.clear()
        nums = [inf]+nums[1:-1]+[inf]
        for i, v in enumerate(nums):
            while stack and nums[stack[-1]] < v:
                idx = stack.pop()
                ssr += nums[idx]*(idx-stack[-1])*(i-idx)
            stack.append(i)
        return ssr
