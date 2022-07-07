import math
import random


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def GenerateOneRandomTree(n):
    if n == 0:
        return None
    if n == 1:
        return TreeNode(n)

    cdf = GetCDF(n)
    seed = random.random()
    numLeftChildren = 0
    for k in cdf:
        if k[1] >= seed > k[0]:
            numLeftChildren = cdf[k]

    root = TreeNode(-1)
    root.left = GenerateOneRandomTree(numLeftChildren)
    root.right = GenerateOneRandomTree(n-1-numLeftChildren)
    return root


def GetCDF(n):

    totalTrees = sum([NumberOfTree(i)*NumberOfTree(n-1-i)
                      for i in range(n)])
    probs = {i: NumberOfTree(i)*NumberOfTree(n-1-i) /
             totalTrees for i in range(n)}
    cdf, start = {}, 0
    for i, p in probs.items():
        cdf[(start, start+p)] = i
        start = start+p
    return cdf


def NumberOfTree(n):
    return math.factorial(2*n) / (math.factorial(n+1)*math.factorial(n))


root = GenerateOneRandomTree(10)
