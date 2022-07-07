class Solution:
    def numDecodings(self, s: str) -> int:
        preDecode, curDecode, preDig = 0, s[0] > "0", ""
        for l in s:
            preDecode, curDecode, preDig = (
                curDecode,
                (l > "0") * curDecode + (9 < int(preDig + l) < 27) * preDecode,
                l,
            )
        return curDecode
