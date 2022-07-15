class Solution:
    '''
    Time: O(n+m) - m is the number of dependencies
    Space: O(n+m)
    '''

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        degree = [0]*numCourses
        courseDic = [[] for i in range(numCourses)]
        for i, j in prerequisites:
            courseDic[j].append(i)
            degree[i] += 1
        dfs = [i for i in range(numCourses) if degree[i] == 0]
        numCoursesFinished = len(dfs)
        while dfs:
            courseId = dfs.pop()
            for c in courseDic[courseId]:
                degree[c] -= 1
                if degree[c] == 0:
                    dfs.append(c)
                    numCoursesFinished += 1
        return numCoursesFinished == numCourses
