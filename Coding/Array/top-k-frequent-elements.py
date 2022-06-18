class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        rank = [[] for _ in range(len(nums)+1)]
        counter = collections.Counter(nums)
        for n, c in counter.items():
            rank[c].append(n)
        return list(chain(*rank))[::-1][:k]
