# Degree of Freedom

# You are given an integer array A of size N. You can divide this array A into any number of contiguous subarrays (possibly zero). The degree of freedom for a subarray is the absolute difference between the maximum and minimum element in a subarray.

# Task: Print the maximum sum of the degree of freedom of all subarrays that can be achieved by dividing A into some possible arrangement of contiguous subarrays

# Note

# •A subarray of an array is a sequence obtained by removing zero or more elements from either both the front and back of the array. The subarrays of array [1,5,2] are ( [1], [1,5], [1,5,2], [5], [5,2], [2] ) but [1,2] cannot be called a subarray of [1,5,2] because it cannot be obtained by removing elements from front or back of [1,5,2] •Contiguous subarray means that all the subarrays should have consecutive indexes. An array [1,2,3] can be divided into contiguous subarray as [1,2,3]or [1,2], [3] or [1] [2,3]
# **
# Example**

# N=5 A = [1,2,1,0,5]

# Approach

# Optimally we can divide A into three consecutive subarrays [1,2], [1] and [0,5]. The degree of freedoms of the subarrays is 1, 0 and 5 respectively. Thus the maximum sum of the degree of freedom of all subarrays is 6.

# A Represents an integer array denoting elements of array A

# Test Cases: N=4; A=[1,4,2,3]; Output=4
# N=5; A=[1,2,3,2,1]; Output=3

class Solution:
    def sumOfDofs(self, nums: List[int]) -> int:
        dof = [0 for _ in nums]
        for i in range(len(nums)):
            dof[i] = max(dof[i-1], dof[i])
            maxn, minn = nums[i], nums[i]
            for j in range(i+1, len(nums)):
                minn = min(minn, nums[j])
                maxn = max(maxn, nums[j])
                dof[j] = max(dof[j], dof[i-1]+maxn-minn)
        return dof[-1]
