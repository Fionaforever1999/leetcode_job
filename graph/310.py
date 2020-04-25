class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
         # 如果数字小于2 说明这个无向图为 0 或者 0，1         
        if n <=2:
            return [i for i in range(n)]
        from collections import deque, defaultdict 
        in_deque = [0] * n # 计数 计算每个元素连接的数目 最高为3 因为是树
        adj = defaultdict(list) # 邻接表 存储 节点邻接的数字 数组形式
        res = [True] * n # 如果没有遍历过设置为True
        
        deques = deque() # 存储外围 当出现频率为1 时加入
        for edge in edges:
            in_deque[edge[0]] += 1
            in_deque[edge[1]] += 1
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
       
        for i in range(n):
            if in_deque[i] == 1:
                deques.append(i)
        while n > 2:
            size = len(deques)
            n -= size # 默认将n的大小减去deque的大小 
            for i in range(size):
                top = deques.popleft() # 获得左边的元素 
                res[top] = False # 将出现频率在本次为1的数字的res设置为false 在最后获取根节点时只用获取res为True 的值
                sub = adj[top] # 邻居的in_deque - 1
                # sub.append(top)
                for j in sub:
                    in_deque[j] -= 1
                    if in_deque[j] == 1:
                        deques.append(j)
        return [i for i in range(len(res)) if res[i]] # n 已经减去值了 所以不能用来做最后的解
