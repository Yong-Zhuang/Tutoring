class Solution:
    def countBits(self, n: int) -> List[int]:
        count = [0]
        for i in range(1, n+1):
            count.append(count[i >> 1]+(i & 1))
        return count

#Time: O(n)
#Space: O(n)
