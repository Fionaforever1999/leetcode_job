class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        b = 2
        ans = 0
        while n>1:
            while n%b==0:
                n /= b
                ans += b 
            b += 1
        return ans