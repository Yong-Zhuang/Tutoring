class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        result = []
        rs, re, cs, ce = 0, len(matrix)-1, 0, len(matrix[0])-1
        while rs <= re and cs <= ce:
            for j in range(cs, ce+1):
                result.append(matrix[rs][j])
            rs += 1
            for i in range(rs, re+1):
                result.append(matrix[i][ce])
            ce -= 1
            if re >= rs:
                for j in range(ce, cs-1, -1):
                    result.append(matrix[re][j])
                re -= 1
            if ce >= cs:
                for i in range(re, rs-1, -1):
                    result.append(matrix[i][cs])
                cs += 1
        return result


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if len(matrix) > 0:
            return [*matrix.pop(0)] + self.spiralOrder([*zip(*matrix)][::-1])
        else:
            return []
