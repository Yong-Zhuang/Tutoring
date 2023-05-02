class Solution:
    def reverseBits(self, n: int) -> int:
        reverse = 0
        for i in range(32):
            reverse = (reverse << 1) ^ (n & 1)
            n = n >> 1
        return reverse

#Time: O(1)
#Space: O(1)
