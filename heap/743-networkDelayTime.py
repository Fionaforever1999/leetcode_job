class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((w, v))
        # defaultdict(<class 'list'>, {2: [(1, 1), (1, 3)], 3: [(1, 4)]})
        dist = {node: float('inf') for node in range(1, N+1)} # 记录的是信号最早到达 node 的时间
        # {1: inf, 2: inf, 3: inf, 4: inf}

        def dfs(node, elapse):
            # elapse 表示延迟时间 
            if dist[node] <= elapse:
                return 
            dist[node] = elapse
            for time, nbr in sorted(graph[node]):
                dfs(nbr, time + elapse)
        dfs(K, 0)
        ans = max(dist.values())
        return ans if ans <float('inf') else -1