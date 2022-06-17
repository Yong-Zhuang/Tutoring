# There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

# You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

# Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

# A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.


# Example 1:

# Input: words = ["wrt","wrf","er","ett","rftt"]
# Output: "wertf"
# Example 2:

# Input: words = ["z","x"]
# Output: "zx"
# Example 3:

# Input: words = ["z","x","z"]
# Output: ""
# Explanation: The order is invalid, so return "".


# Constraints:

# 1 <= words.length <= 100
# 1 <= words[i].length <= 100
# words[i] consists of only lowercase English letters.


class Solution:
    def alienOrder(self, words: List[str]) -> str:
        # words = ["z","x","a","zb","zx"]
        parents = {}
        children = {}
        for w in words:
            for l in w:
                parents[l] = 0
                children[l] = []
        for i in range(len(words)-1):
            for j in range(min(len(words[i]), len(words[i+1]))):
                p, c = words[i][j], words[i+1][j]
                prefix = True
                if p != c:
                    print(p, c, children.get(c), p in children[c])
                    if children.get(c) is not None and p in children[c]:
                        return ""
                    parents[c] += 1
                    children[p] += [c]
                    prefix = False
                    break
            if prefix and len(words[i]) > len(words[i+1]):
                return ""
        roots = []
        for c, p in parents.items():
            if p == 0:
                roots.append(c)
        out = []
        while roots:
            p = roots.pop(0)
            out.append(p)
            for c in children[p]:
                parents[c] -= 1
                if parents[c] == 0:
                    roots.append(c)
        if len(out) != len(parents):
            # print(len(out) , len(parents))
            return ""
        return "".join(out)
