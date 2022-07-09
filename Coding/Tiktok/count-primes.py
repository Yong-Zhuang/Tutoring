class Solution:
    def countPrimes(self, n: int) -> int:
        isPrimes = [1]*(n-2)
        for i in range(2, n):
            if isPrimes[i-2] == 1:
                for j in range(i*i, n, i):
                    isPrimes[j-2] = 0
        return sum(isPrimes)
