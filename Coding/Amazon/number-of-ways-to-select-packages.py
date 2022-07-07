# Find the number of ways to select 3 pages in ascending index order such that no two adjacent pages are of the same type.
# Two types of pages: 0: ordinary page, 1: a bookmarked page.

# Example:
# book = '01001'

# The following Sequences of page match the criterion

# [1, 2, 3], that is 01001 - -> 010
# [1, 2, 4], that is 01001 - -> 010
# [2, 3, 5], that is 01001 - -> 101
# [2, 4, 5], that is 01001 - -> 101
# The Answer is 4.

# Function Description
# Complete the function numberOfWays.
# numberOfWays has the following parameters:
# String book: a string that represents the pages of the book .i.e. book = '01001'

# Returns
# long: the total number of ways to select 3 pages that meet the criterion.


class Solution:
    def numberOfWays(self, s: str) -> int:
        dp = {"0": 0, "10": 0, "010": 0, "1": 0, "01": 0, "101": 0}
        for n in s:
            if n == "0":
                dp["0"] += 1
                dp["10"] += dp["1"]
                dp["010"] += dp["01"]
            if n == "1":
                dp["1"] += 1
                dp["01"] += dp["0"]
                dp["101"] += dp["10"]
        return dp["010"]+dp["101"]
