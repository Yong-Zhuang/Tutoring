class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for i in range(len(nums)):
            if dic.get(target - nums[i]) is not None:
                return [dic[target - nums[i]], i]
            dic[nums[i]] = i


#Time: O(n)
#Space: O(n)
