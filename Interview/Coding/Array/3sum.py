class Solution:
    '''
    Time: O(n^2)
    Space: O(n)
    '''

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        p, n, z = [], [], []
        results = set()
        for i in nums:
            if i > 0:
                p.append(i)
            elif i < 0:
                n.append(i)
            else:
                z.append(i)
        P, N = set(p), set(n)
        if z:
            for i in P:
                if -i in N:
                    results.add((i, 0, -i))
        if len(z) >= 3:
            results.add((0, 0, 0))
        for i in range(len(p)):
            for j in range(i+1, len(p)):
                if -p[i]-p[j] in N:
                    results.add(tuple(sorted((p[i], p[j], -p[i]-p[j]))))
        for i in range(len(n)):
            for j in range(i+1, len(n)):
                if -n[i]-n[j] in P:
                    results.add(tuple(sorted((n[i], n[j], -n[i]-n[j]))))
        return results
