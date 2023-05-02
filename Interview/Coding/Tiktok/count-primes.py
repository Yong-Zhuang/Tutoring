class Solution:
    '''
    Time: O(sqrt(n)loglogn)
    Space: O(n)
    '''

    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        isPrime = [True for _ in range(n)]
        isPrime[0] = isPrime[1] = False
        for i in range(int(sqrt(n))+1):
            if isPrime[i]:
                for j in range(i*i, n, i):
                    isPrime[j] = False
        return sum(isPrime)
