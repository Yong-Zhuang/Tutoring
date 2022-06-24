import heapq


class Solution:
    '''
    Time: O(nlogk)
    '''

    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        return heapq.nsmallest(k, points, key=lambda p: p[0] * p[0] + p[1] * p[1])
