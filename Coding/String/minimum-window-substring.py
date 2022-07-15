class Solution:
    '''
    Time: O(|s|+|t|): In the worst case we might end up visiting every element of string s twice, once by i pointer and once by j pointer.
    Space: O(|s|+|t|): counter length
    '''

    def minWindow(self, s: str, t: str) -> str:
        counter = collections.Counter(t)
        missing = len(t)
        start, end, i = 0, 0, 0
        for j, v in enumerate(s, 1):
            if counter[v] > 0:
                missing -= 1
            counter[v] -= 1
            if missing == 0:
                while i < j and counter[s[i]] < 0:
                    # recover counter[s[i]] because an item k in t occured multiple times before mssing == 0,
                    # we need to stop i at the location of the last k.
                    counter[s[i]] += 1
                    i += 1
                counter[s[i]] += 1
                missing += 1
                if end == 0 or j-i < end-start:
                    start, end = i, j
                i += 1
        return s[start:end]
