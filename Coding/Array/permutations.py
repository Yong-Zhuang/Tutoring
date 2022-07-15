class Solution:
    '''
    Time: O(∑ k=1 N P(N,k)) where P(N, k) = \frac{N!}{(N - k)!} = N (N - 1) ... (N - k + 1)P(N,k)=(N-k)!N!
 =N(N-1)...(N-k+1) 
    Space: O(n!)
    '''

    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        output = []

        def backtracking(start):
            if start == n:
                output.append(nums[:])
            else:
                for i in range(start, n):
                    nums[i], nums[start] = nums[start], nums[i]
                    backtracking(start+1)
                    nums[i], nums[start] = nums[start], nums[i]
        backtracking(0)
        return output
