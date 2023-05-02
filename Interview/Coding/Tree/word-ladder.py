from collections import deque


class Solution:
    '''
    n: number of words in wordList
    m: lenght of each word
    Time: O(n*m*m) Forming each of the intermediate key takes O(m) time because of the substring operation used to create the new string. This adds up to a complexity of O(M²×N).
    Space: O(n*m*m)
    '''

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordDic = {}
        queue = deque([(beginWord, 1)])
        seen = set()
        for w in wordList:
            for i in range(len(w)):
                key = w[:i]+"*"+w[i+1:]
                wordDic.setdefault(key, []).append(w)
        while queue:
            word, length = queue.popleft()
            if word == endWord:
                return length
            for i in range(len(word)):
                nextWords = wordDic.setdefault(word[:i]+"*"+word[i+1:], [])
                for w in nextWords:
                    if w not in seen:
                        seen.add(w)
                        queue.append((w, length+1))
        return 0
