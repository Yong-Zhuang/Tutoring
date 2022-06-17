class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        out = 0
        for n in num_set:
            if n-1 not in num_set:
                y = n+1
                while y in num_set:
                    y += 1
                out = max(out, y-n)
        return out
