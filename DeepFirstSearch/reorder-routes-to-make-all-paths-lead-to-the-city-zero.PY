class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        s = set()
        res = 0
        for c in connections:
            if c[1] == 0:
                s.add(c[0])
            elif c[0] == 0:
                res +=1
                s.add(c[1])
            elif c[1] in s:
                s.add(c[0])
            elif c[0] in s:
                res+=1
                s.add(c[1])
        return res