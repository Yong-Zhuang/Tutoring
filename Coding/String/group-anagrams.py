class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        counter = {}
        for i in strs:
            tuple_i = tuple(sorted(i))
            if counter.get(tuple_i) is not None:
                counter[tuple_i] += [i]
            else:
                counter[tuple_i] = [i]
        return counter.values()
