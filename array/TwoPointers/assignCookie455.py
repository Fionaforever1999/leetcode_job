class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:

        if(len(g)==0 or len(s) == 0): return 0
        g.sort()
        s.sort()
        ans = 0
        index = 0
        for j in s:
            if index <len(g) and j>=g[index]:
                ans += 1
                index +=1        
        return ans
            
