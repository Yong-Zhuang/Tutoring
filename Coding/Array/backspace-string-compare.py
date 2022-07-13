class Solution:
    '''
    Time: O(n)
    Space: O(1)
    '''

    def backspaceCompare(self, s: str, t: str) -> bool:
        cS, cT, bS, bT = len(s)-1, len(t)-1, 0, 0
        while True:
            while cS >= 0 and (s[cS] == "#" or bS > 0):
                if s[cS] == "#":
                    bS += 1
                else:
                    bS -= 1
                cS -= 1
            while cT >= 0 and (t[cT] == "#" or bT > 0):
                if t[cT] == "#":
                    bT += 1
                else:
                    bT -= 1
                cT -= 1
            if not (cT >= 0 and cS >= 0 and s[cS] == t[cT]):
                return cT == cS == -1
            cT -= 1
            cS -= 1
