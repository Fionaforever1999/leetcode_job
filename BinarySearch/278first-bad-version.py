# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo = 1
        hi = n
        while lo < hi:
            mid = (lo + hi) //2
            if isBadVersion(mid)==False:
                lo = mid + 1
            else: hi = mid
        return lo
