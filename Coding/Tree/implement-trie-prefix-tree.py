class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for w in word:
            if cur.children.get(w) is None:
                cur.children[w] = TrieNode()
            cur = cur.children[w]
        cur.isWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for w in word:
            if cur.children.get(w) is None:
                return False
            else:
                cur = cur.children.get(w)
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for w in prefix:
            if cur.children.get(w) is None:
                return False
            else:
                cur = cur.children.get(w)
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
