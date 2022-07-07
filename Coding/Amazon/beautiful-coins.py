
'''
Given a sequence of coins each one facing upward(Head) or downward(Tail), we say it is a 'beautiful' sequence if all heads 
are before the tails. More formally, a beatiful sequence is of the form HH...TTT. For example HHTT, HHHTT, HTTT are beatiful
sequences while HHTHT, THHTT are not.

Note that also only heads or only tails sequence are considered beautiful, e.g. HHH or TTT.
Write a program that takes as input a string representing the coins sequence and output the minimum number of coin 
flips(H -> T or T -> H) necessary to make the sequence beatiful.

For example, given the sequence HHTHTT, the answer should be 1 since it sufficient to flip the last H to make it 
beatiful(HHTTTT).
Can be solved using https://leetcode.com/problems/flip-string-to-monotone-increasing/ replacing "0" with "H" and "1" with "T".
'''


class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        #     Explanation: Our array "S" must be generally sorted as [0]*a + [1]*b
        #         - Examples: 000, 001, 011, 111
        #         - We can sweep through each configuration computing their cost
        # To get started, we assume that we have an array of 1's (111), and every zero must be changed
        # Compute this cost:
        cost = 0
        for x in s:
            if x == 'H':
                cost += 1
        # This is our baseline guess for the best answer
        best = cost
        #     Now we will start allowing zeros up to x=S[i] (last allowed zero)
        #         Check how many zeros can stay for free, and..
        #         How many 1's must be force to change as we advance
        #
        for x in s:  # last 0 allowed
            if x == 'H':
                # this "zero" no longer is a problem (subtract from original cost)
                cost -= 1
            else:
                cost += 1  # this "one" must be forced to change (higher cost)
            best = min(best, cost)
        return best
