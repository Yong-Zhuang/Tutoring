class Solution:
    def isValid(self, s: str) -> bool:
        parentheses_map = {"(": ")", "[": "]", "{": "}"}
        stack = []
        for i in s:
            if parentheses_map.get(i) is not None:
                stack += [i]
            elif len(stack) > 0:
                if parentheses_map[stack.pop()] != i:
                    return False
            else:
                return False
        return len(stack) == 0
