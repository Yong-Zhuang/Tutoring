class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height)-1
        area = 0
        while r > l:
            area = max(area, (r-l)*min(height[l], height[r]))
            if height[l] > height[r]:
                r -= 1
            elif height[l] < height[r]:
                l += 1
            else:
                r -= 1
                l += 1
        return area
