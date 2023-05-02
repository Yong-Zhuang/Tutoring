# Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.


# Example 1:

# Input: intervals = [[0, 30], [5, 10], [15, 20]]
# Output: 2

# Example 2:

# Input: intervals = [[7, 10], [2, 4]]
# Output: 1


# Constraints:

#     - 1 <= intervals.length <= 104
#     - 0 <= starti < endi <= 106


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        num_rooms, temp = 0, 0
        timeline = []
        for i in range(len(intervals)):
            timeline.append((intervals[i][0], +1))
            timeline.append((intervals[i][1], -1))
        for i in sorted(timeline):
            temp += i[1]
            num_rooms = max(num_rooms, temp)
        return num_rooms
