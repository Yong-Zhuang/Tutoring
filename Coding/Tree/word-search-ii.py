class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = None


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        r, c = len(board), len(board[0])
        for w in words:
            cur = root
            for l in w:
                if not cur.children.get(l):
                    cur.children[l] = TrieNode()
                cur = cur.children[l]
            cur.word = w

        def subfun(tboard, i, j, curNode, fro):
            if i >= r or j >= c or i < 0 or j < 0:
                return
            l = tboard[i][j]
            if curNode.children.get(l):
                curNode = curNode.children[l]
                tboard[i][j] = "#"
                if curNode.word:
                    output.append(curNode.word)
                    curNode.word = None
                if fro != "right":
                    subfun(tboard, i, j+1, curNode, "left")
                if fro != "left":
                    subfun(tboard, i, j-1, curNode, "right")
                if fro != "top":
                    subfun(tboard, i-1, j, curNode, "blew")
                if fro != "blew":
                    subfun(tboard, i+1, j, curNode, "top")
                tboard[i][j] = l

        output = []
        for i in range(r):
            for j in range(c):
                subfun(board, i, j, root, None)
        return output
