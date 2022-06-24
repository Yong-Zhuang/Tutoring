'''
Device Application Pairs (Coding Question)
Your team at Amazon is working on a system that divides applications to a mixed cluster of computing devices. Each application is identified by an integer ID, requires a fixed non-zero amount of memory to execute, and is defined to be either a foreground or background application. IDs are guaranteed to be unique within their own application type, but not across types.

Each device should be assigned two applications at once, one foreground application and one background application. Devices have limited amounts of memory and cannot execute applications that require more memory than the available memory. The goal of the system is to maximize the total utilization of the memory of a given device. A foreground/background application pair is considered to be optimal if there does not exist another pair that uses more memory than this pair, and also has a total less than or equal to the total memory of the device. For example, if the device has 10MB memory, a foreground/background pair using a sum total of 9MB memory would be optimal if there does not exist a pair that uses a sum total of 10 MB, but would not be optimal if such a pair did exist.

Write an algorithm to find the sets of foreground and background application pairs that optimally utilize the given device for a given list of foreground applications and a given list of background applications.


Input
The input to the function/method consists of three arguments:
deviceCapacity, an integer representing the maximum capacity of the given device;
foregroundAppList, a list of pairs of integers where the first integer represents the unique ID of a foreground application and the second integer represents the amount of memory required by this application;
backgroundAppList, a list of pairs of integers where the first integer represents the unique ID of a background application and the second integer represents the amount of memory required by this application.

Output
Return a list of pairs of integers representing the pairs of IDs of foreground and background applications that optimally utilize the given device [foregroundAppID,backgroundAppID]. If no pair is possible, return a list with empty pair - not just an empty list.


Examples

Example 1:
Input:
deviceCapacity = 7
foregroundAppList = [[1,2],[2,4],[3,6]]
backgroundAppList = [[1,2]]

Output:
[[2,1]]

Explanation:
There are only three combinations, [1,1], [2,1], and [3,1], which use a total of 4, 6, and 8 MB memory, respectively. Since 6 is the largest use that does not exceed 7, [2,1] is the only optimal pair.


Example2:
Input:
deviceCapacity = 10
foregroundAppList = [[1, 3], [2, 5], [3, 7], [4, 10]]
backgroundAppList = [[1, 2], [2, 3], [3, 4], [4, 5]]

Output:
[[2, 4], [3, 2]]

Explanation:
There are two pairs of foreground and background applications possible that optimally utilizes the given device.
Application 2 from foregroundAppList uses 5 memory units, and application 4 from backgroundAppList also uses 5 memory units. Combined, they add up to 10 units of memory.
Similarly, application 3 from foregroundAppList uses 7 memory units, and application 2 from backgroundAppList uses 3 memory units. These also add up to 10 units of memory.
Therefore, the pairs of foreground and background applications that optimally utilize the device are [2, 4] and [3, 2].


Example3:
Input:
deviceCapacity = 16
foregroundAppList = [[2, 7], [3, 14]]
backgroundAppList = [[2, 10], [3, 14]]

Output:
[()]

Explanation:
There exist no combination. So, the output is a list with empty pair.
'''


from numpy import inf


class Solution(object):

    def applicationPairs(self, deviceCapacity, foregroundAppList, backgroundAppList):
        # Sort apps according to memory, where an app = [id, memory]
        foregroundAppList.sort(key=lambda app: app[1])
        backgroundAppList.sort(key=lambda app: app[1])

        # Initializations
        memUsed = -inf
        result = list()
        # 2 pointer approach
        firstPtr = 0  # For foreground apps, start from min memory utilization
        # For background apps, start from max memory
        secondPtr = len(backgroundAppList) - 1

        while (firstPtr < len(foregroundAppList) and secondPtr >= 0):
            # Total memory usage of current app combinations
            total_mem = foregroundAppList[firstPtr][1] + \
                backgroundAppList[secondPtr][1]

            if total_mem > deviceCapacity:
                # Exceeds device capacity, reduce background memory
                secondPtr -= 1
            else:
                if memUsed <= total_mem:
                    # Better memory utilization with current app combinations
                    if memUsed < total_mem:
                        # If strictly lesser, then current app combination is best, update used memory
                        result.clear()
                        memUsed = total_mem
                    result.append([foregroundAppList[firstPtr][0],
                                   backgroundAppList[secondPtr][0]])
                    bApp = secondPtr

                    # Check next background apps for same memory utilizations
                    while bApp > 0 and backgroundAppList[bApp][1] == backgroundAppList[bApp-1][1]:
                        result.append([foregroundAppList[firstPtr][0],
                                       backgroundAppList[bApp-1][0]])
                        bApp -= 1
                # Move on to next foreground app
                firstPtr += 1

        if not result:
            # To satisfy return value
            return [[]]
        return result


if __name__ == "__main__":
    a = [[1, 2], [2, 4], [3, 6]]
    b = [[1, 2]]
    target = 7
    solution = Solution()
    print(solution.applicationPairs(target, a, b))
    a = [[1, 3], [2, 5], [3, 7], [4, 10]]
    b = [[1, 2], [2, 3], [3, 4], [4, 5]]
    target = 10
    print(solution.applicationPairs(target, a, b))
    a = [[2, 7], [3, 14]]
    b = [[2, 10], [3, 14]]
    target = 16
    print(solution.applicationPairs(target, a, b))

'''
1. Explain coding approach.
For this question, a two-pointer approach has been used. Fundamentally, it checks if the memory utilizations by a combination of foreground and background apps is possible due to the device capacity, and if it is the most optimal memory utilization possible ie. the difference between total device capacity and total memory utilization is the least.
First the two app lists have been sorted on the basis of their memory usage. The pointer for the foreground apps starts from minimum memory usage, while the pointer for the background apps starts from maximum memory usage. A basic check is performed to verify if the total memory utilization is within the device's capacity. If not, then the pointer for background apps is decrememnted thereby, reducing background memory.
If the total memory usage is most optimal, the result list starts from scratch, while if the total memory usage is the same as other combinations, then it is added to the resultant list. If the result list is indeed updated, then a check if performed to add any other background apps which give the same total memory utilization (ie. if they have the same memory).
This process is repeated considering every foreground app one by one.

2. Time complexity analysis.
Assuming the sizes of the foreground and background app lists as m, n respectively. The answer sorts the two arrays at first using a time complexity of O(m*logm) + O(n*logn). However, due to the two pointer approach in the worst case, it would check all combinations of foreground and background apps resulting in an overall time complexity of O(m*n).
'''
