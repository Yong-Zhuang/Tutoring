class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        largest, left, right = -inf, 1, 1
        #here we only need to care about the 0s and negative numbers, for negative numbers, because the subarry is contiguous numbers, we only need to consider whether to remove the first negative number or the last negative number. Thus two cursors from left and right can handle this.
        for i in range(len(nums)):
            left =[left, 1][left==0]*nums[i]
            right = [right,1][right==0]*nums[-1-i]
            largest = max(max(largest,left),right)
        return largest
        