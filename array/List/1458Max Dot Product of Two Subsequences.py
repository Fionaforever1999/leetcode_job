class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        dp = collenctions.defaultdict(int)
        n1, n2 = len(nums1), len(nums2)
        res = (-float('inf'))
        # premax is the value of dp[i-1, j]
        # curmax is the value of dp[i, j]
        premax = [-float('inf')] * n2 
        curmax = [-float('inf')] * n2
        for i in range(n1):
            premax = curmax[::] 
            for j in range(n2):
                v = nums1[i] * nums2[j]
                dp[i, j] = v if(j-1<0) or( premax[j-1] < 0)else v + premax[j-1]
                res = max(res, dp[i, j])
                curmax[j] = max(curmax[j], dp[i, j])
                if(j-1>0):
                    curmax[j] = max(curmax[j], curmax[j-1])
        return res
             