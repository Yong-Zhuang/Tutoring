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
