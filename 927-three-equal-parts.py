class Solution(object):
    def threeEqualParts(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        IMP = [-1, -1]
        s = sum(A)
        if s%3:return IMP
        T = s / 3
        breaks = []
        su = 0
        for i, x in enumerate(A):
            if x:
                su += x
                if su in {1, T+1, 2*T+1}:
                    breaks.append(i)
                if su in {T, 2*T, 3*T}:
                    breaks.append(i)
        i1, j1, i2, j2, i3, j3 = breaks

        if not (A[i1:j1+1]== A[i2:j2+1]==A[i3:j3+1]):
            return [-1, -1]
        x = i2 - j1 -1
        y = i3 - j2 -1
        z = len(A) - j3 -1
        if x < z or y < z:return IMP
        j1 += z
        j2 += z
        return [j1, j2+1]
        

# 三等分比较难 