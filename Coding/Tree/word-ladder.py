class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wDic = {}
        for w in wordList:
            for i in range(len(w)):
                key = w[:i]+"*"+w[i+1:]
                wDic.setdefault(key, []).append(w)

        queue = collections.deque([[beginWord, 1]])
        seen = set(beginWord)
        while queue:
            word, length = queue.popleft()
            if word == endWord:
                return length
            for i in range(len(w)):
                key = word[:i]+"*"+word[i+1:]
                neighbors = wDic.get(key)
                if neighbors is not None:
                    for w in neighbors:
                        if w not in seen:
                            queue.append([w, length+1])
                            seen.add(w)
        return 0
