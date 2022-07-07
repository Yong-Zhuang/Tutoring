class Solution:
    def getSum(self, a: int, b: int) -> int:
        mask = 0xffffffff
        while b:
            addition = (a ^ b) & mask
            carry = ((a & b) << 1) & mask
            a = addition
            b = carry
        if (a >> 31) == 1:
            return ~(a ^ mask)
        return a


#Time: O(1)
#Space: O(1)
