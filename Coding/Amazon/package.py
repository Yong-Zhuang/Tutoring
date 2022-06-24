# To increase efficiency, the Amazon shipping team will group packages being shipped according to weight. They will merge
# a lighter package with a heavier package, which eliminates the need for separate shipments.

# More formally, consider n packages, where packageWeights[i] represents the weight of the ith package. You can combine the
# ith and (i+1)th package if packageWeights[i]<packageWeights[i+1], then discard the ith package. After this operation, the
# number of packages is reduced by 1 and the weight of the (i+1)th package increases by packageWeight[i]. You can merge the
# packages any number of times.

# Find the maximum possible weight of a package that can be achieved after any sequence of merge-operations.


# Example
# For example, packages are described as package_weights = [2,9,10,3,7]

# The optimal order of operations is, using 1-based indexing:
#   - Combine the packages at index 2 and index 3, the new array of package weight becomes[2,19,3,7]
#   - Combine the packages at index 1 and index 2, the new array of package weight becomes[21,3,7]
#   - Combine the packages at index 2 and index 3, the new array of package weight becomes[21,10]

# We cannot combine the packages anymore.

# The weight of the heaviest package achievable after merging is 21.

# Function Description
# Complete the function getHeaviestPackage in the editor below.

# getHeaviestPackage has the following parameter:
#   int packageWeights[n]: the weights of the packages

# Returns
#   long_int: the weight of the heaviest package after merging all possible packages.


# Constraints
# - 1<=n<=2*10^5
# - 1<=packageWeights[i]<=10^9

# Sample Case 0:
# packageWeight[] size n = 4
# packageWeight[] = [20, 13, 8, 9]

# Sample Output: 50
from numpy import inf


def getHeaviestPackage(packageWeights) -> int:
    maxWeight = -float(inf)
    preWeight = 0
    for w in packageWeights[::-1]:
        if preWeight>w:
            w += preWeight
        maxWeight = max(maxWeight, w)
        preWeight = w
    return maxWeight

if __name__ == '__main__':
    print(getHeaviestPackage([2,9,10,3,7]))
    print(getHeaviestPackage([20, 13, 8, 9]))
    
