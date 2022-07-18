class Solution:
    '''
    Time: O(1): There is not more than 27 combinations to check.
    Space: O(1): There is not more than 19 valid IP addresses.
    '''

    def restoreIpAddresses(self, s: str) -> List[str]:

        result = []

        def backTracking(s, block=1, ip=""):

            if block == 5 and not s:
                result.append(ip[:-1])
            elif block < 5:

                for i in range(1, min(4, len(s)+1)):
                    if s[:i] == "0" or (s[0] != "0" and int(s[:i]) <= 255):
                        backTracking(s[i:], block+1, ip+s[:i]+".")

        backTracking(s)
        return result
