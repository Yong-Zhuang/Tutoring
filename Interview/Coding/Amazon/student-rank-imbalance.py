'''
 So you are given an array called rank and it has size of n and all its elements are from 1 to n and there's no duplicates. 
 now there are several rules:

get an subarray of any possible size k (1 <= k <= n)
sort this subarray
find the imbalance of this subarray.
Imbalance is defined as, for each element a[i] at index i, a[i] - a[i - 1] > 1. Then a[i] contributes 1 imbalance. 
e.g. for subarry [1,5,4], after sorting it's [1,4,5]. So 1 and 4 this pair will contribute 1 imbalance. 
but 4 and 5 won't contribute imbalance. But for subarray [1, 4, ,6], there will be 2 imbalance.
Find the total imbalance of all possible subarray
For example, given [4,1,3,2] rank array. There could be [4], [1], [3], [2], [4,1], [1,3], [3,2], [4,1,3],[1,3,2] and 
[4,1,3,2] subarrays. [4,1], [1,3], [4,1,3] each of these 3 subarrays has 1 imbalance. So return 3.
'''


def next_great_element_right(arr):
    n = len(arr)
    res = [n] * n
    # keep non-increasing monotonic array, like 4, 1, 3, 2
    stack = []
    for i in range(n):
        while stack and arr[i] > arr[stack[-1]]:
            res[stack.pop()] = i
        stack.append(i)
    return res


def next_great_element_left(arr):
    n = len(arr)
    res = [-1] * n
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and arr[i] > arr[stack[-1]]:
            res[stack.pop()] = i
        stack.append(i)
    return res


def solve(rank):
    n = len(rank)
    # exclusive boundary
    left_boundary = [-1] * n
    right_boundary = [n] * n
    mp = {}
    # calculate left boundary
    for i in range(n):
        if rank[i] + 1 in mp:
            left_boundary[i] = mp[rank[i] + 1]
        mp[rank[i]] = i

    # calculate right boundary
    mp = {}
    for i in range(n - 1, -1, -1):
        if rank[i] + 1 in mp:
            right_boundary[i] = mp[rank[i] + 1]
        mp[rank[i]] = i

    nge_right = next_great_element_right(rank)
    nge_left = next_great_element_left(rank)

    # calculate possibility of how the i-th number can contribute as a[i-1]
    res = 0
    for i in range(n):
        # possible start value of the sub-array

        count_of_start = i - left_boundary[i]
        count_of_end = right_boundary[i] - i
        total_possible = count_of_start * count_of_end
        smaller_sub_count = (i - nge_left[i]) * (nge_right[i] - i)
        res += (total_possible - smaller_sub_count)
    return res


if __name__ == '__main__':
    print(solve([4, 1, 3, 2]))
