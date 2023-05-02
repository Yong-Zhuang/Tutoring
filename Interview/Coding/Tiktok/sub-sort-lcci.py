class Solution:
    def subSort(self, array: List[int]) -> List[int]:
        n = len(array)
        right, left = -1, -1
        maxVal, minVal = -inf, inf
        for i in range(n):
            if array[i] < maxVal:
                right = i
            else:
                maxVal = array[i]
        for i in range(n-1, -1, -1):
            if array[i] > minVal:
                left = i
            else:
                minVal = array[i]
        return [left, right]
