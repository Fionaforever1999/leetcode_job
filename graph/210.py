class Solution:
    from collections import defaultdict
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list) # 设置图格式为字典式 一个先决课程跟着自己的后面的课 标记为列表格式
        for second, first in prerequisites:
             # 按照顺序记录
            graph[first].append(second)
        v = [0] * numCourses # 0 未知， 1visting 2visted
        ans = []
        for i in range(numCourses):
            if self.dfs(i,graph, ans, v):
                return []# 如果出现 一个是
        return ans[::-1]
    

    def dfs(self, cur, graph, ans, v):# 当前节点 图 当前的栈顺序 当前节点状态
        if v[cur] ==1:return True # 如果正在访问返回True
        if v[cur] == 2 :return False # 否则返回false
        v[cur] =1
        for i in graph[cur]:
            if self.dfs(i, graph, ans, v):return True #如果有环返回True
        v[cur] = 2 # 没有环设置此节点为已访问 
        ans.append(cur) # 将已经访问的节点如栈
        return False

