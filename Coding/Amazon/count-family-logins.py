'''
Given a list of strings, count number of pairs of strings where one string is increment of another.
For eg 'abc', 'bcd'. Each character of 'abc' when incremented gives 'bcd'.
Edit : it is a list of strings. Ex logins : ["bag","cbh","sfe", "red","cbh"]. In this case there are 3 such pairs
at indices (0,1), (0,4,), (3,2). This should return 3
'''
import collections


def countFamilyLogins(arr):
    counter = collections.Counter(arr)
    total = 0
    for st in arr:
        if counter[getIncremented(st)] > 0:
            total += counter[getIncremented(st)]
    return total


def getIncremented(string):
    newStr = ""
    for s in string:
        if s == "Z" or s == "z":
            newStr += chr(ord(s)-25)
        else:
            newStr += chr(ord(s) + 1)
    return newStr


if __name__ == '__main__':
    print(getIncremented("FgZr"))
    arr = ["bag", "cbh", "sfe", "red", "cbh"]
    print(countFamilyLogins(arr))
    arr = ["bag", "cbh", "sfe", "red", "cbh",
           "tgf", "sfy", "sed", "ssd", "efd", "cfd"]
    print(countFamilyLogins(arr))
