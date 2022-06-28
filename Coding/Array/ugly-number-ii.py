class Solution:
    def nthUglyNumber(self, n: int) -> int:
        un = [1]
        i2, i3, i5 = 0, 0, 0
        while len(un) < n:
            while un[i2]*2 <= un[-1]:
                i2 += 1
            while un[i3]*3 <= un[-1]:
                i3 += 1
            while un[i5]*5 <= un[-1]:
                i5 += 1
            un.append(min(min(un[i2]*2, un[i3]*3), un[i5]*5))
        return un[-1]
