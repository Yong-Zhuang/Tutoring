# Your team at Amazon has been contracted by a telecommunications company that is trying to upgrade junction boxes all over
# Techlandia. Some of the junction boxes have already been upgraded, and other boxes have not.
# Your task is to identify the oldest boxes that need to be upgraded first but leaving the newer model boxes
# so that they will not be prioritized. All the junction boxes are identified by an alphanumeric identifier,
# followed by space delimited version information. The older generation uses space delimited lowercase English strings
# to identify the version, but the newer generation uses space delimited positive integers to identify the version.
# Your task is to sort the junction boxes in the following order:

from typing import List
# 1. The older generation junction boxes should be returned first, sorted by lexicographic ordering of alphabetic version.

# 2. If there are any ties in the older generation, ties should be broken by the alphanumeric identifier.

# 3. The newer generation boxes must all come after the older generation, in the original order they were given in the input.

# Write a function or method to return a list of strings representing the correctly prioritized orders according to this system.

# Input

# The input to the function/method consists of one argument:
# boxList, a list of strings representing all of the identifiers and version information.

# Output

# Return a list of strings representing the correctly prioritized orders according to this system.

# Examples

# Input:

# boxList =

# [vkc 82 011[br]
# [Leo first qpx]

# [09z cat hamster]

# [06f 12 25 61[br]
# [azO first qpx]

# [236 cat dog rabbit snake]

# Output:

# [236 cat dog rabbit snake]

# [09z cat hamster]

# [azo first qpx]

# [eo first qpx]

# [ykc 82 01]

# [06f 12 25 6]

# Explanation:

# The four old generation junction boxes should come first, with the "cat dog rabbit snake" box coming before
# the "cat hamster type". Since the two boxes of type "first qpx" have the same version information,
# they should come next, using the "azo" identifier to come before the "eo" identifier. Finally, the already upgraded
# junction boxes should come last, in the original order, they were provided in the file.


def reorder_log_files(logs: List[str]) -> List[str]:
    alphas = []
    nums = []
    for log in logs:
        ident, cont = log.split(' ', 1)
        (alphas if cont[0].isalpha() else nums).append((cont, ident))
    alphas.sort()
    return [f'{i} {c}' for c, i in alphas + nums]


if __name__ == '__main__':
    logs = [input() for _ in range(int(input()))]
    res = reorder_log_files(logs)
    for line in res:
        print(line)
